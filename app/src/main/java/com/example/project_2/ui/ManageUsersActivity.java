package com.example.project_2.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_2.AdminLoggedInPage;
import com.example.project_2.Database.dao.UserDAO;
import com.example.project_2.Database.entities.User;
import com.example.project_2.LoginPage;
import com.example.project_2.MainActivity;
import com.example.project_2.MainPage1;
import com.example.project_2.R;
import com.example.project_2.databinding.ActivityAdminSeeUsersBinding;

import com.example.project_2.Database.*;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class ManageUsersActivity extends AppCompatActivity {
    ActivityAdminSeeUsersBinding binding;
    private UserDAO userDAO;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminSeeUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        if (!AuthPrefs.isAdmin(this)) {
//            Toast.makeText(this, "Not authorized", Toast.LENGTH_SHORT).show();
//            finish();
//            return;
//        }

        userDAO = AppDatabase.getInstance(getApplicationContext()).userDAO();

        RecyclerView recycler = binding.recyclerView;
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter();
        recycler.setAdapter(adapter);

        loadUsers();
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

    public void confirm(View v){
        String username = binding.IDInput.getText().toString().trim();

        if(username.isEmpty()){
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

    public void back(View v){
        startActivity(MainPage1.mainPage1IntentFactory(getApplicationContext()));
    }

    public static Intent manageUsersIntentFactory(Context context){
        return new Intent(context, ManageUsersActivity.class);
    }
}