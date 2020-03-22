package com.kanlulu.aroutertest.ui;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * author:kanlulu
 * data  :2020-03-11 00:10
 *
 **/
@Route(path = "/method/test")
public class TestProvider implements IProvider {
    @Override
    public void init(Context context) {
        //只会在第一调用的时候 init
        Log.e("=test=", "init TestProvider1");
    }

    public void test(Context context) {
        Toast.makeText(context, "TestProvider01", Toast.LENGTH_SHORT).show();
    }
}
