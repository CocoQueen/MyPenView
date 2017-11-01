package com.example.coco.mypenview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mDraw)
    DrawPenView mDraw;
    @BindView(R.id.mBtn1)
    Button mBtn1;
    @BindView(R.id.mBtn2)
    Button mBtn2;
    @BindView(R.id.mBtn3)
    Button mBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mBtn1, R.id.mBtn2, R.id.mBtn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtn1:
                mDraw.setCanvasCode(IPenConfig.STROKE_TYPE_PEN);
                break;
            case R.id.mBtn2:
                mDraw.setCanvasCode(IPenConfig.STROKE_TYPE_BRUSH);
                break;
            case R.id.mBtn3:
                mDraw.setCanvasCode(IPenConfig.STROKE_TYPE_ERASER);
                break;
        }
    }
}
