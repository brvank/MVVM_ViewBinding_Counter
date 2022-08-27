package com.example.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

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

        mActivityMainBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCounter();
            }
        });

        mActivityMainBinding.btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retrieveCounter();
            }
        });

        mActivityMainBinding.swtStorage.setChecked(mCounterViewModel.getSaveStatus());
        switchUpdated(mCounterViewModel.getSaveStatus());
        mActivityMainBinding.swtStorage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                switchUpdated(b);
            }
        });

        updateCounter();
    }

    private void switchUpdated(boolean b){
        mCounterViewModel.setSaveStatus(b);
        if(b){
            mActivityMainBinding.swtStorage.setText("Will save to Shared Preferences");
        }else{
            mActivityMainBinding.swtStorage.setText("Will save to Internal Storage");
        }
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

    private void saveCounter(){
        mCounterViewModel.save();
    }

    private void retrieveCounter(){
        mCounterViewModel.retrieve();
    }
}