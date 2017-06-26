package com.kumar.user.intentservice;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Handler hand = new Handler();
    Button clickme;
    TextView timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.timer);
        clickme = (Button) findViewById(R.id.clickme);
        hand.postDelayed(run, 1000);
}
    Runnable run = new Runnable() {
        @Override
        public void run() {
            updateTime();

        }
    };

    public void updateTime() {
        timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0) {
            clickme.setVisibility(View.VISIBLE);
        } else {
            hand.postDelayed(run, 1000);
        }
    }
}
