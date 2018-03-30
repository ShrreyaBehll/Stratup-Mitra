package com.sih.startupmitra.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by himanshusingh on 15/06/17.
 */

public class SharedPreference {
    private static SharedPreferences mSharedPref;
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private SharedPreference() {

    }

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static void setFirstTimeLaunch(boolean isFirstTime) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        prefsEditor.apply();
    }


    public static boolean isFirstTimeLaunch() {
        return mSharedPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();
    }

    public static String read(String key, String defValue) {
        return mSharedPref.getString(key, defValue);
    }


    public static void write(String key, float value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putFloat(key, value);
        prefsEditor.apply();
    }

    public static Float read(String key, float defValue) {
        return mSharedPref.getFloat(key, defValue);
    }


    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();
    }

    public static boolean read(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }


    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.apply();
    }

    public static Integer read(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void remove(String key) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.remove(key);
        prefsEditor.commit();
    }

    public static void write(String key, long value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putLong(key, value);
        prefsEditor.apply();
    }

    public static long read(String key, long defValue) {
        return mSharedPref.getLong(key, defValue);
    }





}