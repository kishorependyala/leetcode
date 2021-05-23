package com.kp.rbc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void put() {
        LRUCache<Integer,Integer> lruCache = new LRUCache<>(4);
        lruCache.put(10,10);
        lruCache.put(20,20);
        lruCache.put(30,30);
        lruCache.put(40,40);
        lruCache.put(50,50);
        lruCache.put(60,60);
    }

    @Test
    void get() {
        LRUCache<Integer,Integer> lruCache = new LRUCache<>(4);
        lruCache.put(10,10);
        lruCache.put(20,20);
        lruCache.put(30,30);
        lruCache.put(40,40);

        lruCache.get(40);
        lruCache.get(20);
        lruCache.get(30);
        lruCache.get(20);
    }
}