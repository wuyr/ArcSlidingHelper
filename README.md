# ArcSlidingHelper
Android弧形滑动辅助
### 简单使用示例：
```
        mView = findViewById(R.id.view);
        //创建对象
        mArcSlidingHelper = ArcSlidingHelper.create(mView, new ArcSlidingHelper.OnSlidingListener() {
            @Override
            public void onSliding(float angle) {
                mView.setRotation(mView.getRotation() + angle);
            }
        });
        //开启惯性滚动
        mArcSlidingHelper.enableInertialSliding(true);

        getWindow().getDecorView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //处理滑动事件
                mArcSlidingHelper.handleMovement(event);
                return true;
            }
        });
```
### 效果：
![preview](https://github.com/wuyr/ArcSlidingHelper/raw/master/preview.gif) 
### 了解更多: https://github.com/Ifxcyr/ArcSlidingHelper