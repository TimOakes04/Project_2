package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.databinding.ActivityMainPage4Binding;

public class MainPage4 extends AppCompatActivity {
    ActivityMainPage4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public static Intent mainPage4IntentFactory(Context context){
        return new Intent(context, MainPage4.class);
    }
}