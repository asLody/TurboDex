TurboDex: Fast load dex in memory
--------

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-TurboDex-green.svg?style=true)](https://android-arsenal.com/details/1/3456)

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
✘ lody@MacBook-Pro ~/TurboDex/TurboDex/jni> ndk-build                  
SharedLibrary  : libturbo-dex.so
Install        : libturbo-dex.so => libs/armeabi/libturbo-dex.so
SharedLibrary  : libturbo-dex.so
Install        : libturbo-dex.so => libs/x86/libturbo-dex.so
```



## Config

#### Maven

```xml
<dependency>
  <groupId>com.github.asLody</groupId>
  <artifactId>turbodex</artifactId>
  <version>1.1.0</version>
  <type>pom</type>
</dependency>
```

#### Gradle

```groovy
compile 'com.github.asLody:turbodex:1.1.0'
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
new DexClassLoader(...):

DexFile.loadDex(...);
```

## Others analysis and comment
http://note.youdao.com/share/?id=28e62692d218a1f1faef98e4e7724f22&type=note#/

然而，不知道这篇笔记的作者为什么会认为Hook模块是我实现的，
我并没有给Substrate那部分的模块自己命名，而是采用了原名：MSHook，
而且，
所有的Cydia源码我也保留了头部的协议申明，你知道源码的出处，却没有意识到这一点？

## Remark
QQ Group: **535498571**
