package com.example.project_2.auth;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthPrefs {
    private static final String PREFS = "auth_prefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_IS_ADMIN = "is_admin";

    public static void login(Context ctx, String username, boolean isAdmin) {
        SharedPreferences sp = ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        sp.edit().putString(KEY_USERNAME, username).putBoolean(KEY_IS_ADMIN, isAdmin).apply();
    }
    public static void logout(Context ctx) {
        ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().clear().apply();
    }

    public static boolean isLoggedIn(Context ctx) {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).contains(KEY_USERNAME);
    }

    public static String getUsername(Context ctx) {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getString(KEY_USERNAME, "");
    }

    public static boolean isAdmin(Context ctx) {
        return ctx.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean(KEY_IS_ADMIN, false);
    }
}
