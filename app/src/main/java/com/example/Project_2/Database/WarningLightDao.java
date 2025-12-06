package com.example.Project_2.Database;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.Project_2.Database.entities.WarningLight;

import java.util.List;

@Dao
public interface WarningLightDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    long insert(WarningLight light);

    @Update
    void update(WarningLight light);

    @Delete
    void delete(WarningLight light);

    @Query("select * FROM warningLight ORDER BY name ASC")
    List<WarningLight> getAll();

    @Query("SELECT * FROM warningLight WHERE id = :id LIMIT 1")
    WarningLight getByID(int id);
}
