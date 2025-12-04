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
import com.example.project_2.databinding.HighBeamPageBinding;

public class BeamPage extends AppCompatActivity {
    HighBeamPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HighBeamPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Set onclick listener for Backout button
        binding.backOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage4.mainPage4IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent beamPageIntentFactory(Context context){
        return new Intent(context, BeamPage.class);
    }
}