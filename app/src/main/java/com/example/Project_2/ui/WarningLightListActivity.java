package com.example.Project_2.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Project_2.Database.WarningLightDao;
import com.example.Project_2.Database.WarningLightDatabase;
import com.example.Project_2.Database.entities.WarningLight;
import com.example.Project_2.R;

import java.util.List;

public class WarningLightListActivity extends AppCompatActivity {
    private WarningLightAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_light_list);

        RecyclerView recycler = findViewById(R.id.recycler_warninglights);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new WarningLightAdapter();
        recycler.setAdapter(adapter);

        loadWarningLights();
    }

    private void loadWarningLights() {
        WarningLightDatabase.databaseWriteExecutor.execute(() -> {
            WarningLightDao dao = WarningLightDatabase
                    .getInstance(getApplication())
                    .warningLightDao();

            List<WarningLight> lights = dao.getAll();

            runOnUiThread(() -> adapter.setItems(lights));
        });
    }
}
