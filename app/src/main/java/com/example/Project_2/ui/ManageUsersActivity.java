package com.example.Project_2.ui;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Project_2.Database.AppDatabase;
import com.example.Project_2.Database.dao.UserDAO;
import com.example.Project_2.Database.entities.User;
import com.example.Project_2.R;
import com.example.Project_2.auth.AuthPrefs;

import java.util.List;
import java.util.concurrent.Executors;

public class ManageUsersActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;
    private CheckBox adminCheckBox;
    private UserDAO userDAO;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!AuthPrefs.isAdmin(this)) {
            Toast.makeText(this, "Not authorized", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }


        setContentView(R.layout.activity_manage_users);

        usernameInput = findViewById(R.id.input_username);
        passwordInput = findViewById(R.id.input_password);
        adminCheckBox = findViewById(R.id.is_admin);

        Button addButton = findViewById(R.id.button_add_user);
        Button deleteButton = findViewById(R.id.button_delete_user);

        userDAO = AppDatabase.getInstance(getApplicationContext()).userDAO();

        RecyclerView recycler = findViewById(R.id.recycler_users);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        recycler.setAdapter(adapter);

        loadUsers();

        addButton.setOnClickListener(v -> addUser());
        deleteButton.setOnClickListener(v -> deleteUser());
    }

    private void loadUsers() {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<User> users = userDAO.getAll();

            runOnUiThread(() -> {
                Toast.makeText(this, "Loaded " + users.size() + " users", Toast.LENGTH_SHORT).show();
                adapter.setItems(users);
            });
        });
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
            runOnUiThread(() -> {
                Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show();
                loadUsers();
            });
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
                runOnUiThread(() -> {
                        Toast.makeText(this, "User deleted (if existed)", Toast.LENGTH_SHORT).show();
                        loadUsers();
                });
            });
    }
}
