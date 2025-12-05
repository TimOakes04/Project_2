package com.example.project_2;

import static android.os.Build.VERSION_CODES_FULL.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.databinding.ActivityLoginPageBinding;

public class MainActivity extends AppCompatActivity {
    // Make login_page binding (login page will be start page when opening app)
    ActivityLoginPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPageBinding.inflate(getLayoutInflater());
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

    public static Intent mainActivityIntentFactory(Context context){
        return new Intent(context, MainActivity.class);
    }

    /**
     * Check entered username and password against database of users
     * If username and password exist and match, switch to logged in page
     * If username and password don't exist or don't want, switch to failed_sign_in_page
     * @param v
     */
    public void signIn(View v){
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();

        // failed
        if(false) {
            Intent intent = FailedSignInPage.failedSignInPageIntentFactory(getApplicationContext());
            startActivity(intent);
        }
        // passed
        if(true){
            Intent intent = MainPage1.mainPage1IntentFactory(getApplicationContext());
            startActivity(intent);
        }
    }
}