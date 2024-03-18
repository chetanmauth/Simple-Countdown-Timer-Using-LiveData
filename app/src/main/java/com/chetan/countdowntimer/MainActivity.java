package com.chetan.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chetan.countdowntimer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        MyViewModel viewModel= new ViewModelProvider(this).get(MyViewModel.class);

        viewModel.getSeconds().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mainBinding.tvCounter.setText(String.valueOf(integer));
            }
        });

        mainBinding.btnStart.setOnClickListener(view -> {
            viewModel.startTimer(Long.parseLong(mainBinding.etCount.getText().toString()),1000);

        });
    }
}