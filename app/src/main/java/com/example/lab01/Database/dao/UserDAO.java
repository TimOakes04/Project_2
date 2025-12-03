package com.example.lab01.Database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab01.Database.entities.User;
@Dao
public interface UserDAO {

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    User getById (int id);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    User getByUsername (String username);


    @Insert(onConflict = OnConflictStrategy.ABORT)
    long insert(User user);

    @Query("SELECT COUNT(*) FROM users")
    int count();


}
