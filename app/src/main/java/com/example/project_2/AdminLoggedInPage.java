package com.example.project_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.R;
import com.example.project_2.auth.AuthPrefs;
import com.example.project_2.databinding.AdminLoggedInPageBinding;
import com.example.project_2.ui.ManageUsersActivity;
import com.example.project_2.ui.WarningLightListActivity;

public class AdminLoggedInPage extends AppCompatActivity {

    AdminLoggedInPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AdminLoggedInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addNewUserButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ManageUsersActivity.class));
            }
        });

        binding.mainPageButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainPage1.class));
            }
        });
    }
}
