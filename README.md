TurboDex: Fast load dex in memory
--------
[中文](CHINESE.md "中文")

It is generally known that load an **unoptimized Dex file** at runtime
in Android (especially in **ART mode**) would take a **long time**.
When your App is using **MultiDex or PluginFramework**,
You will find that this problem is hard to bear.

TurboDex was born to solve this problem, Like to **opens the god mode** for AndroidVM,
after using TurboDex, no matter how much Dex file your need to load,
it will be finished in **a very short time**.

# Quick Start Guide

## Building TurboDex
TurboDex has given you a **pre-compiled** version in **/Prebuilt**,
if you need to custom the TurboDex, you need to install **Android-NDK**.

```
✘ lody@MacBook-Pro  ~/TurboDex/TurboDex/jni> ndk-build                  
SharedLibrary  : libturbo-dex.so
Install        : libturbo-dex.so => libs/armeabi/libturbo-dex.so
SharedLibrary  : libturbo-dex.so
Install        : libturbo-dex.so => libs/x86/libturbo-dex.so
```

## Usage
To use TurboDex, first add **library** to your project,
Then write the following code in your **Application**:

```java

@Override
protected void attachBaseContext(Context base) {
  TurboDex.enableTurboDex();
  super.attachBaseContext(base);
}


```

After your **enable** the TurboDex, No matter where you load the Dex, it will return quickly.
Example:
```
MultiDex.install(this);

new DexClassLoader(...):

DexFile.loadDex(...);
```


##Remark
QQ Group: **535498571**
