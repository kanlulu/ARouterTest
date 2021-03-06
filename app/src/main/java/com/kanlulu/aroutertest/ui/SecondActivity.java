package com.kanlulu.aroutertest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kanlulu.aroutertest.R;

@Route(path = "/activity/second")
public class SecondActivity extends AppCompatActivity {
    @Autowired(name = "channel_id")
    public int channel_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ARouter.getInstance().inject(this);
        Log.e("=test=", "channel_id：" + channel_id);
    }
}
