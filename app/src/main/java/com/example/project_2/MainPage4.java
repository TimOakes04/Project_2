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

import com.example.project_2.mainPage4.*;

import com.example.project_2.databinding.ActivityMainPage4Binding;

public class MainPage4 extends AppCompatActivity {
    ActivityMainPage4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPage4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener for Continue button
        /*
        binding.page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MainPage5.mainPage5IntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
        */
        // Set onclick listener for Back button
        binding.backButtonMainPage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage3.mainPage3IntentFactory(getApplicationContext()));
            }
        });
    }

    public void Cruise(View v){
        startActivity(CruisePage.cruisePageIntentFactory(getApplicationContext()));
    }
    public void PSteering(View v){
        startActivity(PSteeringPage.pSteeringPageIntentFactory(getApplicationContext()));
    }
    public void Beam(View v){
        startActivity(BeamPage.beamPageIntentFactory(getApplicationContext()));
    }


    public static Intent mainPage4IntentFactory(Context context){
        return new Intent(context, MainPage4.class);
    }
}