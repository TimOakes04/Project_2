package com.example.lab01.Database;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.lab01.Database.entities.WarningLight;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {WarningLight.class}, version = 1, exportSchema = false)
public class WarningLightDatabase {
    private static final String DATABASE_NAME = "WarningLight_database";
    public static final String WARNING_LIGHT_TABLE = "warningLightTable";
    private static volatile WarningLightDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

}
