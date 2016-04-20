#include "XJniHook.h"
#include "Logger.h"
#include "core/FastLoadDex.h"


void Java_com_lody_turbodex_TurboDex_nativeEnableTurboDex(JNIEnv* env,jobject thiz) {
	enableFastLoadDex();
}

void Java_com_lody_turbodex_TurboDex_nativeDisableTurboDex(JNIEnv* env,jobject thiz) {
	closeFastLoadDex();
}

