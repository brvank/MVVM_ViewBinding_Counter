package com.example.mvvm.Repository;

import android.content.Context;

import com.example.mvvm.Model.Counter;
import com.example.mvvm.Services.Storage.InternalStorage;
import com.example.mvvm.Services.Storage.SharedPreferencesStorage;
import com.example.mvvm.Util.AppConstants;
import com.example.mvvm.Util.AppLog;
import com.example.mvvm.Util.AppProcess;

public class CounterRepo {
    private Context mContext;
    private Counter mCounter;
    private SharedPreferencesStorage mSharedPreferencesStorage;
    private InternalStorage mInternalStorage;

    public CounterRepo(Context context, boolean status){
        mContext = context;
        mCounter = new Counter();
        mSharedPreferencesStorage = new SharedPreferencesStorage(mContext);
        mInternalStorage = new InternalStorage(mContext);

        retrieveCounter(status);
    }

    public void updateCounter(Integer value, boolean status){
        mCounter.setValue(value);
        if(status){
            mSharedPreferencesStorage.set(AppConstants.COUNTER, mCounter.toString());
        }else{
            mInternalStorage.writeFile(AppConstants.COUNTER_FILE, mCounter.toString());
        }
    }

    public Counter retrieveCounter(boolean status){
        String res = "";
        if(status){
            res = mSharedPreferencesStorage.get(AppConstants.COUNTER);
        }else{
            res = mInternalStorage.readFile(AppConstants.COUNTER_FILE);
        }
        Integer integer = AppProcess.stringToInt(res);
        mCounter.setValue(integer);

        return mCounter;
    }

    public Counter getCounter(){
        return mCounter;
    }
}
