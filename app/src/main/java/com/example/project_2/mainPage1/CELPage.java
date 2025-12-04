package com.example.project_2.mainPage1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.MainPage1;
import com.example.project_2.databinding.CheckEnginePageBinding;

public class CELPage extends AppCompatActivity {
    CheckEnginePageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CheckEnginePageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Set onclick listener for Back button
        binding.backOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainPage1.mainPage1IntentFactory(getApplicationContext()));
            }
        });
    }

    public static Intent celPageIntentFactory(Context context){
        return new Intent(context, CELPage.class);
    }
}