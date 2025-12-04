package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.databinding.ActivityMainPage2Binding;
import com.example.project_2.mainPage2.*;

public class MainPage2 extends AppCompatActivity {

    ActivityMainPage2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Set onclick listener to Continue button
        binding.page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainPage3.mainPage3IntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });

        // Set onclick listener to Back button
        binding.backButtonMainPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage1.mainPage1IntentFactory(getApplicationContext()));
            }
        });
    }

    public void LTP(View v){
        startActivity(LTPPage.ltpPageIntentFactory(getApplicationContext()));
    }
    public void Battery(View v){
        startActivity(BatteryPage.batteryPageIntentFactory(getApplicationContext()));
    }
    public void Temp(View v){
        startActivity(TempPage.tempPageIntentFactory(getApplicationContext()));
    }

    public static Intent mainPage2IntentFactory(Context context){
        return new Intent(context, MainPage2.class);
    }
}