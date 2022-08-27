package com.example.mvvm.ViewModel;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.Model.Counter;
import com.example.mvvm.Repository.CounterRepo;
import com.example.mvvm.Util.AppApplication;
import com.example.mvvm.Util.AppLog;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Counter> mCounterMutableLiveData;
    private CounterRepo mCounterRepo;
    private Counter mCounter;
    private boolean mSaveStatus;

    public CounterViewModel(){
        mSaveStatus = true;

        mCounterRepo = new CounterRepo(AppApplication.getContext(), mSaveStatus);
        mCounter = mCounterRepo.getCounter();

        mCounterMutableLiveData = new MutableLiveData<>();
        mCounterMutableLiveData.setValue(mCounter);
    }

    public void addCounterObserver(LifecycleOwner owner, Observer observer){
        mCounterMutableLiveData.observe(owner, observer);
    }

    public String getCounterValue(){
        mCounter = mCounterMutableLiveData.getValue();
        return mCounter.toString();
    }

    public void increment(){
        mCounter = mCounterMutableLiveData.getValue();
        mCounter.increment();
        mCounterMutableLiveData.setValue(mCounter);
    }

    public void decrement(){
        mCounter = mCounterMutableLiveData.getValue();
        mCounter.decrement();
        mCounterMutableLiveData.setValue(mCounter);
    }

    public void reset(){
        mCounter = mCounterMutableLiveData.getValue();
        mCounter.reset();
        mCounterMutableLiveData.setValue(mCounter);
    }

    public void save(){
        mCounterRepo.updateCounter(mCounter.getValue(), mSaveStatus);
    }

    public void retrieve(){
        mCounter = mCounterRepo.retrieveCounter(mSaveStatus);
        mCounterMutableLiveData.setValue(mCounter);
    }

    public void setSaveStatus(boolean value){
        mSaveStatus = value;
    }

    public boolean getSaveStatus(){
        return mSaveStatus;
    }
}
