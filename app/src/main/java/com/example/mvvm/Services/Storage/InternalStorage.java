package com.example.mvvm.Services.Storage;

import android.content.Context;

import com.example.mvvm.Util.AppAlert;
import com.example.mvvm.Util.AppConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InternalStorage {
    private Context mContext;

    public InternalStorage(Context context){
        mContext = context;
    }

    public File getFile(String fileName){
        boolean status = true;
        File file = new File(mContext.getFilesDir(), fileName);
        try{
            if(!file.exists()){
                status = file.createNewFile();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return status ? file : null;
    }

    public void writeFile(String fileName, String data){
        try{
            File file = getFile(fileName);
            if(file != null) {
                FileOutputStream fileOutputStream = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
                fileOutputStream.write(data.getBytes(StandardCharsets.UTF_8));
                AppAlert.toast(mContext, AppConstants.FILE_SAVED + file.getAbsolutePath());
            }else{
                AppAlert.toast(mContext, AppConstants.DATA_NOT_SAVED);
            }
        }catch (Exception e){
            e.printStackTrace();
            AppAlert.toast(mContext, AppConstants.DATA_NOT_SAVED);
        }
    }

    public String readFile(String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        try{
            File file = getFile(fileName);
            if(file != null){
                FileInputStream fileInputStream = mContext.openFileInput(fileName);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while(line != null){
                    stringBuilder.append(line).append("\n");
                    line = bufferedReader.readLine();
                }
            }else{
                AppAlert.toast(mContext, AppConstants.DATA_NOT_READ);
            }
        }catch (Exception e){
            e.printStackTrace();
            AppAlert.toast(mContext, AppConstants.DATA_NOT_READ);
        }
        return stringBuilder.toString().replace("\r", "").replace("\n", "");
    }
}
