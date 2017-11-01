package com.example.coco.mypenview;

/**
 * Created by coco on 2017/11/1.
 */

public class ControllerPoint {
    public float x;
    public float y;

    public float width;
    public int alpha = 225;

    public ControllerPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public ControllerPoint() {

    }

    public void set(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    public void set(ControllerPoint point) {
        this.x = point.x;
        this.y = point.y;
        this.width = point.width;
    }

    @Override
    public String toString() {
        return "ControllerPoint{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", alpha=" + alpha +
                '}';
    }
}
