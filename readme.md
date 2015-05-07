#继承LinActivity实现沉浸式状态栏
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setChenjinContentView(R.layout.activity_second);//填充布局
    setChenjinColor(Color.RED);//设置状态栏颜色
}