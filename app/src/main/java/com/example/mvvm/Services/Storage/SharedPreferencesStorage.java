package com.example.mvvm.Services.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvvm.Util.AppConstants;

public class SharedPreferencesStorage {
    private Context mContext;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SharedPreferencesStorage(Context context){
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(AppConstants.SF, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public String get(String field){
        return mSharedPreferences.getString(field, "");
    }

    public void set(String field, String value){
        mEditor.putString(field, value);
        mEditor.apply();
    }
}
