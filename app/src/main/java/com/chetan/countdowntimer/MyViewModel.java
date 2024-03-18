package com.chetan.countdowntimer;

import android.os.CountDownTimer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private CountDownTimer timer;

    private MutableLiveData<Integer> countSeconds=new MutableLiveData<>();
    private boolean timerRunning=false;

    public MyViewModel() {
    }

    public LiveData<Integer> getSeconds() {
        return countSeconds;
    }

    public void startTimer(long time_ms, long interval_ms) {

        //cancel timer if running
        if(timerRunning){
            timer.cancel();
        }

        timer = new CountDownTimer(time_ms*1000, interval_ms) {
            @Override
            public void onTick(long l) {
                long sec = l / 1000;
                countSeconds.setValue((int) sec);
            }

            @Override
            public void onFinish() {
                countSeconds.setValue(0);
                timerRunning=false;
            }
        };
        timer.start();
        timerRunning=true;
    }
}
