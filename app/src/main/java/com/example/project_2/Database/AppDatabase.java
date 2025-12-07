package com.example.project_2.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.project_2.Database.dao.UserDAO;
import com.example.project_2.Database.entities.User;

import java.util.concurrent.Executors;

@Database(
        entities = {User.class},
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase{

    public abstract UserDAO userDAO();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class){
                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        "warningLight-db"
                )
                        .addCallback(new Callback() {
                            @Override
                            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                super.onCreate(db);
                                Executors.newSingleThreadExecutor().execute(() -> {
                                  AppDatabase d = getInstance(context);
                                  UserDAO dao = d.userDAO();
                                  if (dao.count() == 0) {
                                      dao.insert(new User("testuser1", "testuser1", false));
                                      dao.insert(new User("admin1", "admin1", true));
                                  }
                                });
                            }
                        })
                        .build();
            }
        }
    return INSTANCE;
    }
}
