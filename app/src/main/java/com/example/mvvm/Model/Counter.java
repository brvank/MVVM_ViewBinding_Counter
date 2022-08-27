package com.example.mvvm.Model;

import androidx.annotation.NonNull;

public class Counter {
    Integer mCounter;

    public Counter(){
        mCounter = 0;
    }

    public void increment(){
        mCounter++;
    }

    public void decrement(){
        mCounter--;
    }

    public void reset(){
        mCounter = 0;
    }

    @NonNull
    @Override
    public String toString() {
        return mCounter.toString();
    }
}
