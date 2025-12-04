package com.example.project_2.mainPage4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.MainPage4;
import com.example.project_2.R;
import com.example.project_2.databinding.CruiseControlPageBinding;

public class CruisePage extends AppCompatActivity {
    CruiseControlPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CruiseControlPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener for Backout button
        binding.backOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage4.mainPage4IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent cruisePageIntentFactory(Context context){
        return new Intent(context, CruisePage.class);
    }
}