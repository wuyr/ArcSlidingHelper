## 几行代码实现Android弧形滑动
### 博客详情：https://blog.csdn.net/u011387817/article/details/80313184

### 使用方式:
#### 添加依赖：
```
implementation 'com.wuyr:arcslidinghelper:1.0.0'
```

### APIs:
|Method|Description|
|------|-----------|
|create(View targetView, OnSlidingListener listener)|创建实例<br>targetView: 圆弧滑动事件以此View的中心点为圆心<br>OnSlidingListener: 旋转事件回调|
|enableInertialSliding(boolean enable)|设置是否开启惯性滑动|
|setSelfSliding(boolean isSelfSliding)|设置是否自身滑动 (即接受触摸事件的View和旋转的View是否同一个对象)|
|setScrollAvailabilityRatio(float ratio)|设置惯性滑动的利用率 (范围:0~1, 数值越大,旋转越激进)|
|setOnSlideFinishListener(OnSlideFinishListener listener)|设置滚动完毕监听器|
|handleMovement(MotionEvent event)|处理触摸事件|
|updateMovement(MotionEvent event)|更新当前手指触摸的坐标，在ViewGroup的onInterceptTouchEvent中使用|
|updatePivotX(int pivotX)|更新圆心x坐标|
|updatePivotY(int pivotY)|更新圆心y坐标|
|abortAnimation()|停止本次滚动|
|release()|释放资源|

### 简单使用示例：
```java
    private ArcSlidingHelper mArcSlidingHelper;
    private View mView;

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
```

### Demo下载: [app-debug.apk](https://github.com/wuyr/ArcSlidingHelper/raw/master/app-debug.apk)
### 库源码地址： https://github.com/Ifxcyr/ArcSlidingHelper
### 可定制性超强的圆弧滑动组件: https://github.com/Ifxcyr/FanLayout

### 效果：
![preview](https://github.com/wuyr/ArcSlidingHelper/raw/master/previews/preview.gif) ![preview](https://github.com/wuyr/ArcSlidingHelper/raw/master/previews/preview2.gif)
