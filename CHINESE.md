TurboDex: 在Android瞬间加载Dex
--------

众所周知,Android中在Runtime加载一个 **未优化的Dex文件** (尤其在 **ART 模式**)需要花费 **很长的时间**.
当你在App中使用 **插件化框架** 的时候, 首次加载插件就需要耗费很长的时间.

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
  <version>1.1.0</version>
  <type>pom</type>
</dependency>
```

#### Gradle

```groovy
compile 'com.github.asLody:turbodex:1.1.0'
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
new DexClassLoader(...):

DexFile.loadDex(...);
```
## 其它的分析和评论
http://note.youdao.com/share/?id=28e62692d218a1f1faef98e4e7724f22&type=note#/

然而，不知道这篇笔记的作者为什么会认为Hook模块是我实现的，
我并没有给Substrate那部分的模块自己命名，而是采用了原名：MSHook，
而且，
所有的Cydia源码我也保留了头部的协议申明，你知道源码的出处，却没有意识到这一点？

## Remark
QQ Group: **535498571**
