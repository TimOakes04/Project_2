package com.example.project_2.Database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project_2.Database.entities.WarningLight;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {WarningLight.class}, version = 1, exportSchema = false)
public abstract class WarningLightDatabase extends RoomDatabase {

    public abstract WarningLightDao warningLightDao();
    private static final String DATABASE_NAME = "WarningLight_database";
    public static final String WARNING_LIGHT_TABLE = "warningLightTable";
    private static volatile WarningLightDatabase INSTANCE;

    public static WarningLightDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (WarningLightDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WarningLightDatabase.class,
                            DATABASE_NAME
                    ).build();
                }
            }
        }
        return INSTANCE;
    }

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

}
