package com.example.pupil.projectoo;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences implements  ISharedPreferences {
    private static String NAME="com.example.pupil.projectoo";
    private static String IS_FIRST="IS_FIRST";
    private SharedPreferences preferences;
    public MySharedPreferences(MainActivity context){
        this.preferences=context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
    }

    @Override
    public Boolean isFirstStart() {
        return preferences.getBoolean((IS_FIRST),true);
    }

    @Override
    public void setisFirstStart(Boolean isFirst) {
        preferences.edit().putBoolean(IS_FIRST,isFirst).apply();

    }

}
