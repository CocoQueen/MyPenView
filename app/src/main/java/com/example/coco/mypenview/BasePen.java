package com.example.coco.mypenview;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by coco on 2017/11/1.
 */

public abstract class BasePen {
    public abstract  void draw(Canvas canvas);

    /**
     * 接受并处理onTouchEvent
     *
     * @param event
     * @return
     */
    public  boolean onTouchEvent(MotionEvent event, Canvas canvas){
        return false;
    }

}
