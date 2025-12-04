package com.example.project_2.mainPage2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.MainPage1;
import com.example.project_2.MainPage2;
import com.example.project_2.databinding.TpmsPageBinding;

public class LTPPage extends AppCompatActivity {
    TpmsPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TpmsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener for Backout button
        binding.backOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage2.mainPage2IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent ltpPageIntentFactory(Context context){
        return new Intent(context, LTPPage.class);
    }
}