#继承LinActivity实现沉浸式状态栏

1、在Android Studio中增加依赖
```xml
compile 'com.linwoain.library:lin_library:1.0.3'
```
2、将自己的Activity继承自LinActivity并修改填充布局方式并设置状态栏颜色

```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setChenjinContentView(R.layout.activity_second);//填充布局
    setChenjinColor(Color.RED);//设置状态栏颜色
}