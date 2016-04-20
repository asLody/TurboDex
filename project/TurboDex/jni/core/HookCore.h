#ifndef ____HookCore__
#define ____HookCore__

#include "../MSHook/Hooker.h"
#define LIBC_SO "libc.so"

#define HOOK(func) Cydia::elfHookFunction("libc.so", #func, (void*) my_##func, (void**) &org_##func)


#endif /* defined(____HookCore__) */