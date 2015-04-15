package com.linwoan.library;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linwoain.ui.LinActivity;
import com.linwoain.util.LLogUtils;


public class MainActivity extends LinActivity {

    @ViewInject(R.id.tv)
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ViewUtils.inject(this);
        LLogUtils.d("haha");
        tv.setText("inject后的值");

    }


}
