package com.ex.oleg.switcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isOn = false;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener()
        {
                 @Override
                 public void onClick(View v) {
                     isOn = !isOn;
                     if(isOn)
                     {
                         image.setImageResource(R.drawable.on);
                     }
                     else
                     {
                         image.setImageResource(R.drawable.off);
                     }
                 }
             }
        );
    }
}
