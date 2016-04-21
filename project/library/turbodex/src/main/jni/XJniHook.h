#ifndef __PLUGIN_HOOK_H_
#define __PLUGIN_HOOK_H_
#include <jni.h>


#ifdef __cplusplus
extern "C" {
#endif
	
void Java_com_lody_turbodex_TurboDex_nativeEnableTurboDex(JNIEnv* env,jobject thiz);

void Java_com_lody_turbodex_TurboDex_nativeDisableTurboDex(JNIEnv* env,jobject thiz);

#ifdef __cplusplus
}
#endif

#endif //__PLUGIN_HOOK_H_
