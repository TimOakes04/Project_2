package com.example.project_2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.R;
import com.example.project_2.databinding.ActivitySignUpPageBinding;

import java.util.concurrent.Executors;


public class SignUpPage extends AppCompatActivity {

    ActivitySignUpPageBinding binding;

    public static Intent signUpPageIntentFactory(Context ctx) {
        return new Intent(ctx, SignUpPage.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backButtonMainPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.mainActivityIntentFactory(getApplicationContext()));
            }
        });
    }

    public void signUp(View v) {
        String username = binding.newUsername.getText().toString().trim();
        String password = binding.newPassword.getText().toString().trim();
        String confirm = binding.reNewPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!password.equals(confirm)) {
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
            return;
        }

        Executors.newSingleThreadExecutor().execute(() -> {
            boolean created = AuthRepository.createUser(
                    getApplicationContext(),
                    username,
                    password,
                    false
            );

            runOnUiThread(() -> {
                if (!created) {
                    Toast.makeText(SignUpPage.this,
                            "Username already exists",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpPage.this,
                            "Account created. You can log in now.",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        });
    }

}
