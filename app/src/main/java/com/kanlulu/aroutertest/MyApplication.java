package com.kanlulu.aroutertest;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author:kanlulu
 * data  :2020-03-10 22:16
 **/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();

    }

    private void initARouter() {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
