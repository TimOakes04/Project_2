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

import com.example.project_2.databinding.ActivityMainPage3Binding;
import com.example.project_2.mainPage3.*;

public class MainPage3 extends AppCompatActivity {
    ActivityMainPage3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener to Continue button
        binding.page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainPage4.mainPage4IntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        // Set onclick listener to Back button
        binding.backButtonMainPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage2.mainPage2IntentFactory(getApplicationContext()));
            }
        });
    }

    public void TCT(View v){
        startActivity(TCSPage.tcsPageIntentFactory(getApplicationContext()));
    }
    public void SRS(View v){
        startActivity(SRSPage.srsPageIntentFactory(getApplicationContext()));
    }
    public void Brake(View v){
        startActivity(BrakePage.brakePageIntentFactory(getApplicationContext()));
    }

    public static Intent mainPage3IntentFactory(Context context){
        return new Intent(context, MainPage3.class);
    }
}