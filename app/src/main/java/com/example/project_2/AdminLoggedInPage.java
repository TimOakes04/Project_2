package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.databinding.ActivityAdminLoggedInPageBinding;

public class AdminLoggedInPage extends AppCompatActivity {
    ActivityAdminLoggedInPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminLoggedInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainPageButtonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage1.mainPage1IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent activityAdminLoggedInPageIntentFactory(Context context){
        return new Intent(context, AdminLoggedInPage.class);
    }
}