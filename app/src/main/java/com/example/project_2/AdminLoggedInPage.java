package com.example.project_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.project_2.R;
import com.example.project_2.auth.AuthPrefs;
import com.example.project_2.ui.ManageUsersActivity;
import com.example.project_2.ui.WarningLightListActivity;

public class AdminLoggedInPage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_logged_in_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button manageUsersButton = findViewById(R.id.button_manage_users);
        Button viewLightsButton = findViewById(R.id.button_view_warning_lights);
        Button logoutButton = findViewById(R.id.button_logout);

        manageUsersButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ManageUsersActivity.class);
            startActivity(intent);
        });

        viewLightsButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, WarningLightListActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            AuthPrefs.logout(this);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
