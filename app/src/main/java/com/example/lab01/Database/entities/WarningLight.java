package com.example.lab01.Database.entities;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "warningLight")
public class WarningLight {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;

    public WarningLight(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
