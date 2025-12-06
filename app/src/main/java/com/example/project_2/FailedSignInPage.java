package com.example.project_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project_2.databinding.ActivityFailedSignInPageBinding;

public class FailedSignInPage extends AppCompatActivity {
    ActivityFailedSignInPageBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFailedSignInPageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Set onclick listener for signup button to change to signup page view
        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SignUpPage.signUpPageIntentFactory(getApplicationContext());
                startActivity(intent);
            }
        });
    }

    /**
     * Check entered username and password against database of users
     * If username and password exist and match, switch to logged in page
     * If username and password don't exist or don't want, don't do anything
     * @param v
     */
    public void signIn(View v){
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();

        // Check against database
    }

    public static Intent failedSignInPageIntentFactory(Context context){
        return new Intent(context, FailedSignInPage.class);
    }
}