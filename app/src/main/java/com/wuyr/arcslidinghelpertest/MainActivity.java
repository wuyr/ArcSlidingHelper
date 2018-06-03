package com.wuyr.arcslidinghelpertest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wuyr.ArcSlidingHelper;

/**
 * Created by wuyr on 18-5-9 上午1:36.
 */
public class MainActivity extends AppCompatActivity {

    private ArcSlidingHelper mArcSlidingHelper;
    private View mView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_view);

        mView = findViewById(R.id.view);
        mView.post(() -> {
            //创建对象
            mArcSlidingHelper = ArcSlidingHelper.create(mView,
                    angle -> mView.setRotation(mView.getRotation() + angle));
            //开启惯性滚动
            mArcSlidingHelper.enableInertialSliding(true);
            mArcSlidingHelper.setOnSlideFinishListener(() -> Toast.makeText(
                    MainActivity.this,"finished",Toast.LENGTH_SHORT).show());
        });
        getWindow().getDecorView().setOnTouchListener((v, event) -> {
            //处理滑动事件
            mArcSlidingHelper.handleMovement(event);
            return true;
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放资源
        mArcSlidingHelper.release();
    }
}
