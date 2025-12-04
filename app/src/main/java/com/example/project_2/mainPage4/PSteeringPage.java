package com.example.project_2.mainPage4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.MainPage4;
import com.example.project_2.databinding.PowerSteeringPageBinding;

public class PSteeringPage extends AppCompatActivity {

    PowerSteeringPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PowerSteeringPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener for Backout button
        binding.backOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage4.mainPage4IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent pSteeringPageIntentFactory(Context context){
        return new Intent(context, PSteeringPage.class);
    }
}