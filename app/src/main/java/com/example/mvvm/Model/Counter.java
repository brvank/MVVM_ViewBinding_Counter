package com.example.mvvm.Model;

import androidx.annotation.NonNull;

public class Counter {
    Integer mValue;

    public Counter(){
        mValue = 0;
    }

    public void increment(){
        mValue++;
    }

    public void decrement(){
        mValue--;
    }

    public void reset(){
        mValue = 0;
    }

    public void setValue(Integer value){
        mValue = value;
    }

    public Integer getValue() {
        return mValue;
    }

    @NonNull
    @Override
    public String toString() {
        return mValue.toString();
    }
}
