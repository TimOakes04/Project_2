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

import com.example.project_2.databinding.AbsPageBinding;

public class ABSPage extends AppCompatActivity {
    AbsPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AbsPageBinding.inflate(getLayoutInflater());
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

    public static Intent absPageIntentFactory(Context context){
        return new Intent(context, ABSPage.class);
    }
}