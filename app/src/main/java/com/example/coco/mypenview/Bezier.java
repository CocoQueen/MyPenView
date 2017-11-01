package com.example.coco.mypenview;

/**
 * Created by coco on 2017/11/1.
 */

public class Bezier {
    private ControllerPoint mControll = new ControllerPoint();
    private ControllerPoint mDestination = new ControllerPoint();
    private ControllerPoint mNextCntroll = new ControllerPoint();
    private ControllerPoint mSource = new ControllerPoint();

    public Bezier() {

    }

    public void init(ControllerPoint last, ControllerPoint cur) {
        init(last.x, last.y, last.width, cur.x, cur.y, cur.width);
    }

    private void init(float lastx, float lasty, float lastwidth, float x1, float y1, float width1) {
        mSource.set(lastx, lasty, lastwidth);
        float xmid = getMid(lastx, x1);
        float ymid = getMid(lasty, y1);
        float widmid = getMid(lastwidth, width1);
        mDestination.set(xmid, ymid, widmid);
        mControll.set(getMid(lastx, xmid), getMid(lasty, ymid), getMid(lastwidth, widmid));
        mNextCntroll.set(x1, y1, width1);


    }

    public void addNode(ControllerPoint cur) {
        addNode(cur.x, cur.y, cur.width);
    }

    public void addNode(float x, float y, float width) {
        mSource.set(mDestination);
        mControll.set(mNextCntroll);
        mDestination.set(getMid(mNextCntroll.x, x), getMid(mNextCntroll.y, y), getMid(mNextCntroll.width, width));
        mNextCntroll.set(x, y, width);
    }

    public void end() {
        mSource.set(mDestination);
        float x = getMid(mNextCntroll.x, mSource.x);
        float y = getMid(mNextCntroll.y, mSource.y);
        float width = getMid(mNextCntroll.width, mSource.width);
        mControll.set(x, y, width);
        mDestination.set(mNextCntroll);

    }

    public ControllerPoint getPoint(double t) {
        float x = (float) getX(t);
        float y = (float) getY(t);
        float w = (float) getW(t);
        ControllerPoint point = new ControllerPoint();
        point.set(x, y, w);
        return point;
    }

    private double getValue(double p0, double p1, double p2, double t) {
        double A = p2 - 2 * p1 + p0;
        double B = 2 * (p1 - p0);
        double C = p0;
        return A * t * t + B * t + C;
    }

    private double getX(double t) {
        return getValue(mSource.x, mControll.x, mDestination.x, t);
    }

    private double getY(double t) {
        return getValue(mSource.y, mControll.y, mDestination.y, t);
    }

    private double getW(double t) {
        return getWidth(mSource.width, mDestination.width, t);
    }

    private float getMid(float x1, float x2) {
        return (float) ((x1 + x2) / 2.0);
    }

    private double getWidth(double w0, double w1, double t) {
        return w0 + (w1 - w0) * t;
    }


}
