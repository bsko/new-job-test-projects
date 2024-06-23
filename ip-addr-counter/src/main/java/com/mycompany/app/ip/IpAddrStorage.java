package com.mycompany.app.ip;

public class IpAddrStorage {
    private final static int DEFAULT_ARRAY_SIZE = 256;
    private final boolean[][][][] storage = new boolean[DEFAULT_ARRAY_SIZE][][][];
    private int count = 0;

    public Integer getTotalCount() {
        return count;
    }

    public void count(int[] ipv4address) {
        if (ipv4address != null) {
            if (store(ipv4address)) count++;
        }
    }

    private boolean store(int[] ipv4address) {
        if (storage[ipv4address[0]] == null) storage[ipv4address[0]] = new boolean[DEFAULT_ARRAY_SIZE][][];
        if (storage[ipv4address[0]][ipv4address[1]] == null) storage[ipv4address[0]][ipv4address[1]] = new boolean[DEFAULT_ARRAY_SIZE][];
        if (storage[ipv4address[0]][ipv4address[1]][ipv4address[2]] == null) storage[ipv4address[0]][ipv4address[1]][ipv4address[2]] = new boolean[DEFAULT_ARRAY_SIZE];
        if (storage[ipv4address[0]][ipv4address[1]][ipv4address[2]][ipv4address[3]]) return false;
        storage[ipv4address[0]][ipv4address[1]][ipv4address[2]][ipv4address[3]] = true;
        return true;
    }
}
