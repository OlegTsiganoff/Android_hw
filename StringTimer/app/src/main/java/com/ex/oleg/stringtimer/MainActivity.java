package com.ex.oleg.stringtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    Timer timer;

    TextView textHours;
    TextView textMinutes;
    TextView textSeconds;
    String[] nums;
    String[] tens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textHours = (TextView)findViewById(R.id.textTimeHours);
        textMinutes = (TextView)findViewById(R.id.textTimeMinutes);
        textSeconds = (TextView)findViewById(R.id.textTimeSeconds);
        timer = new Timer("my_timer");
        timer.schedule(new MyTimerTask(this), 2000, 1000);
        nums = getResources().getStringArray(R.array.timeNumbers);
        tens = getResources().getStringArray(R.array.tensNumbers);
    }


    void RefreshTime()
    {
        Calendar calendar = Calendar.getInstance();
        String strHours;
        String strMinutes;
        String strSeconds;
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        strHours = getTimeString(hours);
        strMinutes = getTimeString(minutes);
        strSeconds = getTimeString(seconds);

        textHours.setText(strHours);
        textMinutes.setText(strMinutes);
        textSeconds.setText(strSeconds);

        ((TextView)findViewById(R.id.textTimeNumbers)).setText(hours + ":" + minutes + ":" + seconds);
    }

    String getTimeString(int value)
    {
        if(value < 20)
        {
            return nums[value];
        }
        else
        {
            String number = "";
            if(value / 10 > 0 && value % 10 > 0)
                number = nums[value % 10];
            return tens[value / 10] + " " + number;
        }
    }
}