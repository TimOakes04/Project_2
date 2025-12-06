package com.example.Project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Project_2.R;



public class FailedSignInPage extends AppCompatActivity {

    public static Intent failedSignInPageIntentFactory(Context context) {
        return new Intent(context, FailedSignInPage.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed_sign_in_page);


        Button signUpButton = findViewById(R.id.signUpButton);
        if (signUpButton != null) {
            signUpButton.setOnClickListener(v -> {
                Intent intent = SignUpPage.signUpPageIntentFactory(getApplicationContext());
                startActivity(intent);
            });
        }
    }
}
