package com.example.project_2.ui;


import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_2.Database.AppDatabase;
import com.example.project_2.Database.dao.UserDAO;
import com.example.project_2.Database.entities.User;
import com.example.project_2.R;
import com.example.project_2.auth.AuthPrefs;
import com.example.project_2.databinding.ActivityManageUsersBinding;

import java.util.List;
import java.util.concurrent.Executors;

public class ManageUsersActivity extends AppCompatActivity {
    ActivityManageUsersBinding binding;
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


        binding = ActivityManageUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        usernameInput = binding.inputUsername;
        passwordInput = binding.inputPassword;
        adminCheckBox = binding.isAdmin;

        Button addButton = binding.buttonAddUser;
        Button deleteButton = binding.buttonDeleteUser;

        userDAO = AppDatabase.getInstance(getApplicationContext()).userDAO();

        RecyclerView recycler = binding.recyclerUsers;
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
