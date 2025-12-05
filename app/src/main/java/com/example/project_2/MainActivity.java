package com.example.project_2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;


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


    /**
     * Check entered username and password against database of users
     * If username and password exist and match, switch to logged in page
     * If username and password don't exist or don't want, switch to failed_sign_in_page
     * @param v
     */
    public void signIn(View v){
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();


        // For now just default to failed_sign_in page
        Intent intent = FailedSignInPage.failedSignInPageIntentFactory(getApplicationContext());
        startActivity(intent);
    }
}
