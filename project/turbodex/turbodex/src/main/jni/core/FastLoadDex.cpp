#include "FastLoadDex.h"
#include "HookCore.h"

#define DEX2OAT_BIN "/system/bin/dex2oat"

#define DEBUG 1

static bool hooked = false;
static bool enable = false;

int (*org_execv)(const char *name, char **argv);

int my_execv(const char *name, char **argv) {
	#ifdef DEBUG
	LOGD("#execv %s.", name);
	#endif

	if(enable && strcmp(name, DEX2OAT_BIN) == 0) {
		exit(0);
	}
		
  	return org_execv(name, argv);
}

void enableFastLoadDex() {
	if(!hooked) {
		HOOK(execv);
		hooked = true;
	}
	enable = true;
}

void closeFastLoadDex() {
	enable = false;
}
