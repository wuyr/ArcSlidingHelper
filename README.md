## 几行代码实现Android弧形滑动
### 添加依赖：
build.gradle:
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://github.com/Ifxcyr/ArcSlidingHelper/raw/master" }
    }
}
```
app/build.gradle:
```
implementation 'com.wuyr:arcslidinghelper:1.0.0'
```
### 简单使用示例：
```
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
### 效果：
![preview](https://github.com/wuyr/ArcSlidingHelper/raw/master/preview.gif) ![preview](https://github.com/wuyr/ArcSlidingHelper/raw/master/preview2.gif)
### 了解更多: https://github.com/Ifxcyr/ArcSlidingHelper
### 可定制性超强的圆弧滑动组件:https://github.com/Ifxcyr/FanLayout
