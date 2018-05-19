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
![preview](https://img-blog.csdn.net/20180520035234277?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTEzODc4MTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70) ![preview](https://img-blog.csdn.net/20180520041746179?/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTEzODc4MTc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
### 了解更多: https://github.com/Ifxcyr/ArcSlidingHelper
