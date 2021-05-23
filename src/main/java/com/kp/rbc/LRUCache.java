package com.kp.rbc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRUCache<K,V> {


    private final int MAX_ENTRIES;
    private DoubleLinkedList<V> doubleLinkedList = new DoubleLinkedList<>();
    private Map<K, DoubleLinkedList<V>.Node<V>> valueMap = new HashMap<>();
    private int size = 0;

    public LRUCache(int maxentries){
        this.MAX_ENTRIES = maxentries;
    }

    public void put(K key, V value){
        if(size == MAX_ENTRIES){
            System.out.println("Reached threshold - removing least recently used element");
            doubleLinkedList.removeFirst();
        }
        DoubleLinkedList<V>.Node<V> node = doubleLinkedList.addNode(value);
        this.valueMap.put(key,node);
        size++;
        doubleLinkedList.print();
    }

    public V get(K key){
        DoubleLinkedList<V>.Node<V> vNode = this.valueMap.get(key);
        doubleLinkedList.moveNodeToLast(vNode);
        doubleLinkedList.print();
        return vNode.value;
    }

    public void print() {
        doubleLinkedList.print();
    }

}
