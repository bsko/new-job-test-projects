package com.mycompany.app.ip;

public class IpAddrFormatter {
    private static final Integer MIN_VALUE = 0;
    private static final Integer MAX_VALUE = 256;
    public int[] format(String line) {
        String[] partsByDot = line.trim().split("\\.");
        if (partsByDot.length != 4) return null;
        int[] result = new int[4];
        for (int i = 0; i < 4; i++) {
            result[i] = transformToInt(partsByDot[i]);
        }
        return result;
    }

    private int transformToInt(String source) {
        int i = Integer.parseInt(source);
        if (i < MIN_VALUE || i > MAX_VALUE) {
            return 0;
        }
        return i;
    }
}
