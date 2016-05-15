package com.example.student.staticmembers;

import android.graphics.Color;

/**
 * Created by student on 24.03.2016.
 */
public class Raspberry {

    public final double size;
    public final int color;
    public final double height;
    public final double spread;
    public final double minWeigh;
    public final double maxWeigh;

    public Raspberry(double size, int color, double height, double spread, double minWeigh, double maxWeigh) {
        this.size = size;
        this.color = color;
        this.height = height;
        this.spread = spread;
        this.minWeigh = minWeigh;
        this.maxWeigh = maxWeigh;
    }
}
