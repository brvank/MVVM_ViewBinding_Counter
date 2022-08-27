package com.example.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvm.Model.Counter;
import com.example.mvvm.ViewModel.CounterViewModel;
import com.example.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mActivityMainBinding;
    CounterViewModel mCounterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mActivityMainBinding.getRoot());

        init();
    }

    private void init(){
        mCounterViewModel = new ViewModelProvider(this).get(CounterViewModel.class);
        mCounterViewModel.addCounterObserver(this, new Observer<Counter>() {
            @Override
            public void onChanged(Counter counter) {
                updateCounter();
            }
        });

        mActivityMainBinding.btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrementCounter();
            }
        });

        mActivityMainBinding.btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incrementCounter();
            }
        });

        mActivityMainBinding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetCounter();
            }
        });

        updateCounter();
    }

    private void incrementCounter(){
        mCounterViewModel.increment();
    }

    private void decrementCounter(){
        mCounterViewModel.decrement();
    }

    private void resetCounter(){
        mCounterViewModel.reset();
    }

    private void updateCounter(){
        mActivityMainBinding.tvCounter.setText(mCounterViewModel.getCounterValue());
    }
}