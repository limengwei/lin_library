package com.linwoan.library;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.linwoain.library.LViewHelper;
import com.linwoain.ui.LinActivity;
import com.linwoain.util.LLogUtils;
import com.linwoain.util.ScreenUtil;


public class MainActivity extends LinActivity {

    @ViewInject(R.id.tv)
    private TextView tv;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = LViewHelper.getView(R.layout.activity_main, this);
        setContentView(R.layout.activity_main);
////        ScreenUtil.setchenjin(this);
//        setContentView(view);
//        setFullScreen();
////        ScreenUtil.setchenjin(this,findViewById(R.id.root));
//
//       ViewUtils.inject(this);
//        LLogUtils.d("haha");
//        tv.setText("inject后的值");




//        ScreenUtil.setchenjin(this);
        ScreenUtil.setChenjinColor(this,Color.BLUE);

    }


}
