TurboDex: 在Android瞬间加载Dex
--------

众所周知,Android中在Runtime加载一个 **未优化的Dex文件** (尤其在 **ART 模式**)需要花费 **很长的时间**.
当你在App中使用 **MultiDex 或 插件化框架** 的时候,
这个问题就会显得十分严重.

TurboDex 就是为了解决这一问题而生, 就像是给AndroidVM开启了上帝模式,
在引入TurboDex后, 无论你加载了多大的Dex文件,都可以在毫秒级别内完成.

# Quick Start Guide

## Building TurboDex
TurboDex的 **pre-compiled** 版本在 **/Prebuilt** 目录下,
如果你想要构建自己的TurboDex, 你需要安装 **Android-NDK**.

```
✘ lody@MacBook-Pro  ~/TurboDex/TurboDex/jni> ndk-build                  
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
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

#### Gradle

```groovy
compile 'com.github.asLody:turbodex:1.0.0'
```



## Usage
使用TurboDex, 你需要将**library** 添加到你的项目中,
在 **Application** 中写入以下代码:

```java

@Override
protected void attachBaseContext(Context base) {
  TurboDex.enableTurboDex();
  super.attachBaseContext(base);
}


```

**开启** TurboDex后, 下列调用都不再成为拖慢你App运行的元凶:
```
MultiDex.install(this);

new DexClassLoader(...):

DexFile.loadDex(...);
```


##Remark
QQ Group: **535498571**
