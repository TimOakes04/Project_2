package com.example.project_2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.project_2.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page2);

        Button continueButton = findViewById(R.id.page2);
        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage2Activity.this, MainPage3Activity.class);
            startActivity(intent);
        });
    }
}