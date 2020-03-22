package com.kanlulu.aroutertest.ui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author:kanlulu
 * data  :2020-03-10 23:01
 **/
public class SchemeFilterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        if (uri != null) {
            ARouter.getInstance().build(uri).navigation();
        }
        finish();
    }
}
