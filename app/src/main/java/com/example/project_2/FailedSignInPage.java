package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_2.Database.entities.User;
import com.example.project_2.R;
import com.example.project_2.auth.AuthPrefs;
import com.example.project_2.databinding.ActivityFailedSignInPageBinding;
import com.example.project_2.ui.ManageUsersActivity;

import java.util.concurrent.Executors;


public class FailedSignInPage extends AppCompatActivity {

    public static Intent failedSignInPageIntentFactory(Context context) {
        return new Intent(context, FailedSignInPage.class);
    }

    ActivityFailedSignInPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFailedSignInPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SignUpPage.signUpPageIntentFactory(getApplicationContext()));
            }
        });
    }

    public void signIn(View v) {
        String username = binding.username.getText().toString().trim();
        String password = binding.password.getText().toString().trim();

        Executors.newSingleThreadExecutor().execute(() -> {
            User user = AuthRepository.authenticate(getApplicationContext(), username, password);

            runOnUiThread(() -> {
                if (user == null) {
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
}
