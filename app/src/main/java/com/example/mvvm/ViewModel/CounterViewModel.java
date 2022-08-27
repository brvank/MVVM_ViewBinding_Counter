package com.example.mvvm.ViewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.Model.Counter;

public class CounterViewModel extends ViewModel {
    private MutableLiveData<Counter> mCounterMutableLiveData;
    private Counter mCounter;

    public CounterViewModel(){
        mCounterMutableLiveData = new MutableLiveData<>();
        mCounterMutableLiveData.setValue(new Counter());
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
}
