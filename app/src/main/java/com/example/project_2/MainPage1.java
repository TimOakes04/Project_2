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

import com.example.project_2.databinding.ActivityFailedSignInPageBinding;
import com.example.project_2.databinding.ActivityMainPage1Binding;

public class MainPage1 extends AppCompatActivity {

    ActivityMainPage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    public static Intent mainPage1IntentFactory(Context context){
        return new Intent(context, MainPage1.class);
    }
}