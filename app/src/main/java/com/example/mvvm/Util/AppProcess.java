package com.example.mvvm.Util;

public class AppProcess {
    public static Integer stringToInt(String string){
        try{
            return Integer.parseInt(string);
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
