package com.tbd.app;

import android.content.Context;

import com.lody.turbodex.TurboDex;

/**
 * Created by qiujuer
 * on 16/4/22.
 */
public class Application extends android.app.Application {
    @Override
    protected void attachBaseContext(Context base) {
        TurboDex.enableTurboDex();
        super.attachBaseContext(base);
    }
}
