package com.example.Project_2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.example.Project_2.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page1);

        Button continueButton = findViewById(R.id.page2);
        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainPage1Activity.this, MainPage2Activity.class);
            startActivity(intent);
        });
    }


}
 