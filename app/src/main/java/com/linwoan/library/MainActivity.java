package com.linwoan.library;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.linwoain.library.LApplication;
import com.linwoain.ui.Translucent;


public class MainActivity extends Activity {
    Translucent translucent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translucent = new Translucent(this).inject();
        translucent.setStatusBarColor(Color.RED);

    }

    public void change(View view) {
        translucent.setStatusBarColor(Color.YELLOW);
    }
}
