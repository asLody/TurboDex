package com.lody.turbodex;

/**
 * @author Lody
 * @version 1.3
 */
public class TurboDex {

    static {
        System.loadLibrary("turbo-dex");
    }

    static native void nativeEnableTurboDex();

    static native void nativeDisableTurboDex();

    public static boolean enableTurboDex() {
        if (isArtMode()) {
            try {
                nativeEnableTurboDex();
                return true;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void disableTurboDex() {
        try {
            nativeDisableTurboDex();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    /**
     * In current version, only enable TBD at ART mode.
     *
     * @return current Environment is ART mode
     */
    private static boolean isArtMode() {
        return System.getProperty("java.vm.version", "").startsWith("2");
    }
}
