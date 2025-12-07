package com.example.project_2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.Database.entities.User;
import com.example.project_2.auth.AuthPrefs;
import com.example.project_2.ui.MainPage1Activity;
import com.example.project_2.ui.ManageUsersActivity;

import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {
    // Make login_page binding (login page will be start page when opening app)
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        Button signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(v -> {
            Intent intent = SignUpPage.signUpPageIntentFactory(MainActivity.this);
            startActivity(intent);
        });
    }
    public void signIn(View v) {
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        Executors.newSingleThreadExecutor().execute(() -> {
            User user = AuthRepository.authenticate(getApplicationContext(), username, password);

            runOnUiThread(() -> {
                if (user == null) {
                    Intent intent = FailedSignInPage.failedSignInPageIntentFactory(MainActivity.this);
                    startActivity(intent);
                    return;
                }

                AuthPrefs.login(this, user.getUsername(), user.isAdmin());

                if (user.isAdmin()) {
                    startActivity(ManageUsersActivity.manageUsersIntentFactory(getApplicationContext()));
                } else {
                    startActivity(MainPage1.mainPage1IntentFactory(getApplicationContext()));
                }

                finish();
            });
        });
    }

    public static Intent mainActivityIntentFactory(Context context){
        return new Intent(context, MainActivity.class);
    }
}
