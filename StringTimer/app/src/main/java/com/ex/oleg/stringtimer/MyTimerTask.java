package com.ex.oleg.stringtimer;

import java.util.TimerTask;

/**
 * Created by User on 06.07.2016.
 */
public class MyTimerTask extends TimerTask
{
    MainActivity activity;
    public MyTimerTask(MainActivity mainActivity)
    {
        activity = mainActivity;
    }

    @Override
    public void run()
    {
        activity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                activity.RefreshTime();
            }
        });
    }
}
