package com.ex.oleg.viewswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener
{

    LinearLayout mainLayout;
    LinearLayout parentLayout_1;
    LinearLayout parentLayout_2;
    LinearLayout layout_1;
    LinearLayout layout_2;
    LinearLayout layout_3;
    LinearLayout layout_4;
    Button buttonSwitch;
    ArrayList<LinearLayout> list;
    int animationCounter = 0;
    boolean isFadeIn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSwitch = (Button)findViewById(R.id.buttonSwitch);
        mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
        parentLayout_1 = (LinearLayout)findViewById(R.id.parentLayout_1);
        parentLayout_2 = (LinearLayout)findViewById(R.id.parentLayout_2);
        layout_1 = (LinearLayout)findViewById(R.id.layout_1);
        layout_2 = (LinearLayout)findViewById(R.id.layout_2);
        layout_3 = (LinearLayout)findViewById(R.id.layout_3);
        layout_4 = (LinearLayout)findViewById(R.id.layout_4);
        list = new ArrayList<>();
        list.add(layout_1);
        list.add(layout_2);
        list.add(layout_3);
        list.add(layout_4);

    }

    public void OnClick(View view)
    {
        buttonSwitch.setEnabled(false);
        AnimateFadeIn();
    }

    void AnimateFadeIn() {
        isFadeIn = true;
        mainLayout.startAnimation(GetAnimation(true));
    }

    void AnimateFadeOut() {
        isFadeIn = false;
        mainLayout.startAnimation(GetAnimation(false));
    }


    AlphaAnimation GetAnimation(boolean fadeIn)
    {
        float start = 0.0F;
        float end = 1.0F;
        if(fadeIn)
        {
            start = 1.0F;
            end = 0.0F;
        }
        AlphaAnimation animation = new AlphaAnimation(start, end);
        animation.setDuration(200);
        animation.setStartOffset(0);
        //animation.setFillAfter(true);
        animation.setAnimationListener(this);
        return animation;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (isFadeIn) {
            LinearLayout tmp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, tmp);
            parentLayout_1.removeAllViews();
            parentLayout_2.removeAllViews();
            parentLayout_1.addView(list.get(0));
            parentLayout_1.addView(list.get(1));
            parentLayout_2.addView(list.get(3));
            parentLayout_2.addView(list.get(2));
            AnimateFadeOut();
        } else {
            buttonSwitch.setEnabled(true);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
