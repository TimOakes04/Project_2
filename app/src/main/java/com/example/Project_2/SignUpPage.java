package com.example.Project_2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.Project_2.R;

import java.util.concurrent.Executors;


public class SignUpPage extends AppCompatActivity {

    private EditText newUsernameInput;
    private EditText newPasswordInput;
    private EditText reNewPasswordInput;

    public static Intent signUpPageIntentFactory(Context ctx) {
        return new Intent(ctx, SignUpPage.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        newUsernameInput = findViewById(R.id.newUsername);
        newPasswordInput = findViewById(R.id.newPassword);
        reNewPasswordInput = findViewById(R.id.reNewPassword);

        Button signUpButton = findViewById(R.id.signUpNewButton);
        signUpButton.setOnClickListener(v -> signUp());
    }

    private void signUp() {
        String username = newUsernameInput.getText().toString().trim();
        String password = newPasswordInput.getText().toString().trim();
        String confirm = reNewPasswordInput.getText().toString().trim();

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
