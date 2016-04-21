NDK_TOOLCHAIN_VERSION=4.8
APP_ABI := arm64-v8a armeabi armeabi-v7a x86 x86_64
APP_STL=gnustl_static
APP_CPPFLAGS := -std=c++11 -fexceptions -frtti
APP_CPPFLAGS +=-fpermissive