package com.example.lab01;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int user_id;
    public String username;
    public String password;
    public boolean is_admin;
}
