package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.databinding.ActivityMainPage1Binding;
import com.example.project_2.mainPage1.*;

public class MainPage1 extends AppCompatActivity {

    ActivityMainPage1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Set onclick listener to Continue button
        binding.page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainPage2.mainPage2IntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        binding.backButtonMainPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext()));
            }
        });
    }

    public void CEL(View v){
        startActivity(CELPage.celPageIntentFactory(getApplicationContext()));
    }
    public void LOP(View v){
        startActivity(LOPPage.lopPageIntentFactory(getApplicationContext()));
    }
    public void ABS(View v){
        startActivity(ABSPage.absPageIntentFactory(getApplicationContext()));
    }

    public static Intent mainPage1IntentFactory(Context context){
        return new Intent(context, MainPage1.class);
    }
}