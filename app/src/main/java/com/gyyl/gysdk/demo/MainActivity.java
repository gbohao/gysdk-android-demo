package com.gyyl.gysdk.demo;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import com.gyyl.gysdk.GYSdk;
import com.gyyl.gysdk.entity.GYOption;
import com.gyyl.gysdk.exception.GYException;

public class MainActivity extends ComponentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start_sdk).setOnClickListener(v -> {

            GYOption options = new GYOption();
            // 配置appKey，必填
            options.setAppKey("");
            // 配置oaid，和imei必须至少有一个，推荐oaid
            options.setOaid("");
            // 配置imei，和oaid必须至少有一个，推荐oaid
            options.setImei("");
            // 配置用户唯一标识，必填
            options.setTargetId("");
            // 配置是否显示AppBar，默认true显示
            options.setShowAppBar(true);
            // 配置主题色
            options.setThemeColor("#2196F3");
            // 配置列表页面标题，默认"亘元有量"
            options.setTitle("");
            // 配置微信appId，如果需要打开微信小程序则必须设置
            options.setWxAppId("");
            try {
                GYSdk.start(MainActivity.this, options);
            } catch (GYException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
