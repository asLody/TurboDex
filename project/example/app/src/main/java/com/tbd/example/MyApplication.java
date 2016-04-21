package com.tbd.example;

import android.app.Application;
import android.content.Context;

import com.lody.turbodex.TurboDex;

import dalvik.system.DexClassLoader;

/**
 * @author Lody
 * @version 1.0
 */
public class MyApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        TurboDex.enableTurboDex();
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        String optDir = getDir("sec-dex", MODE_PRIVATE).getPath();
        DexClassLoader dl = new DexClassLoader(
                "/sdcard/classes2.dex", //classes.dex
                optDir,                                                    //Opt dir
                null,                                                      //Lib dir
                ClassLoader.getSystemClassLoader().getParent());           //Parent ClassLoader
    }
}
