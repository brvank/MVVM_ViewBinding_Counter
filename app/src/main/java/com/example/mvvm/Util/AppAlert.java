package com.example.mvvm.Util;

import android.content.Context;
import android.widget.Toast;

public class AppAlert {
    public static void toast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
