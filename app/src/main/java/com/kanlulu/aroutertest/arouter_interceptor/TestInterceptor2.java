package com.kanlulu.aroutertest.arouter_interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * author:kanlulu
 * data  :2020-03-11 00:02
 **/

@Interceptor(priority = 2,name = "test_interceptor")
public class TestInterceptor2 implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("=test=","TestInterceptor 拦截");
//        callback.onInterrupt(new RuntimeException("我觉得不行！！！"));
        callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {
        Log.e("=test=","听说你只会被调用一次 TestInterceptor2");

    }
}
