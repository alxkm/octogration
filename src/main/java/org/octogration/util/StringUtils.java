package org.octogration.util;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
