package com.kanlulu.aroutertest.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kanlulu.aroutertest.MyConstant;
import com.kanlulu.aroutertest.R;
import com.kanlulu.aroutertest.service.FloatingVideoService;

@Route(path = "/activity/main")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToSecond(View view) {
        ARouter.getInstance().build("/activity/second")
                .navigation(this);
    }

    public void jumpParams(View view) {
        ARouter.getInstance().build(MyConstant.URI_SECOND_ACTIVITY)
                .withInt("channel_id",10)
                .navigation(this);
    }


    public void jumpUri(View view) {
        ARouter.getInstance().build(Uri.parse("router://kanlulu.com/activity/uri"))
                .withInt("channel_id",15)
                .navigation(this);
    }

    public void jumpCallback(View view) {
        ARouter.getInstance().build(MyConstant.URI_SECOND_ACTIVITY)
                .navigation(this, new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.e("=test=","跳转完成");

                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.e("=test=","跳转被拦截了");
                    }

                });
    }

    //依赖注入
    public void providerTest(View view) {
        ARouter.getInstance().navigation(TestProvider.class).test(this);
    }


    public void showFloatingView(View view) {
        if (FloatingVideoService.isStarted) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 2);
            } else {
                startService(new Intent(MainActivity.this, FloatingVideoService.class));
            }
        }else {
            startService(new Intent(MainActivity.this, FloatingVideoService.class));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                    startService(new Intent(MainActivity.this, FloatingVideoService.class));
                }
            }
        }
    }
}
