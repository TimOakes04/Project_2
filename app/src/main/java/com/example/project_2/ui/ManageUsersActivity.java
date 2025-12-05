package com.example.project_2.ui;

import static android.app.ProgressDialog.show;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.Database.AppDatabase;
import com.example.project_2.Database.dao.UserDAO;
import com.example.project_2.Database.entities.User;
import com.example.project_2.R;
import com.example.project_2.auth.AuthPrefs;

import java.util.concurrent.Executors;

public class ManageUsersActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private CheckBox adminCheckBox;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!AuthPrefs.isAdmin(this)) {
            Toast.makeText(this, "Not authorized", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setContentView(R.layout.activity_sign_up_page);

        usernameInput = findViewById(R.id.newUsername);
        passwordInput = findViewById(R.id.newPassword);
        adminCheckBox = findViewById(R.id.is_admin);

        Button addButton = findViewById(R.id.button_add_user);
        Button deleteButton = findViewById(R.id.button_delete_user);

        userDAO = AppDatabase.getInstance(getApplicationContext()).userDAO();

        addButton.setOnClickListener(v -> addUser());
        deleteButton.setOnClickListener(v -> deleteUser());
    }

    private void addUser() {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();
        boolean isAdmin = adminCheckBox.isChecked();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username and password required", Toast.LENGTH_SHORT).show();
            return;
        }

        Executors.newSingleThreadExecutor().execute(() -> {
            userDAO.insert(new User(username, password, isAdmin));
            runOnUiThread(() ->
                    Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show()
            );
        });
        }
        private void deleteUser() {
        String username = usernameInput.getText().toString().trim();

        if (username.isEmpty()) {
            Toast.makeText(this, "Username required", Toast.LENGTH_SHORT).show();
            return;
        }

            Executors.newSingleThreadExecutor().execute(() -> {
                userDAO.deleteByUsername(username);
                runOnUiThread(() ->
                        Toast.makeText(this, "User deleted (if existed)", Toast.LENGTH_SHORT).show()
                );
            });
    }
}
