package com.example.Project_2;

import android.content.Context;

import com.example.Project_2.Database.AppDatabase;
import com.example.Project_2.Database.dao.UserDAO;
import com.example.Project_2.Database.entities.User;

public class AuthRepository {

    public static User authenticate(Context context, String username, String password) {
        UserDAO dao = AppDatabase.getInstance(context).userDAO();
        User user = dao.getByUsername(username);
        if (user == null) return null;
        if (!user.getPassword().equals(password)) return null;
        return user;
    }

    public static boolean createUser(Context context, String username, String password, boolean isAdmin) {
        UserDAO dao = AppDatabase.getInstance(context).userDAO();
        User existing = dao.getByUsername(username);
        if (existing != null) return false;
        dao.insert(new User(username, password, isAdmin));
        return true;

    }
}
