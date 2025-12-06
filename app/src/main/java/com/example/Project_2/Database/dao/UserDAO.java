package com.example.Project_2.Database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.Project_2.Database.entities.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    User getById (int id);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    User getByUsername (String username);


    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(User user);

    @Query("SELECT COUNT(*) FROM users")
    int count();

    @Query("DELETE FROM users WHERE username = :username")
    void deleteByUsername(String username);

    @Query("SELECT * FROM users")
    List<User> getAll();


}
