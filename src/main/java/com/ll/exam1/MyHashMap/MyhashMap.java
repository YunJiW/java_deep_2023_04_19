package com.ll.exam1.MyHashMap;

import java.util.HashMap;

public class MyhashMap<K,V> {

    private final Object[] keys;
    private final Object[] values;

    private int size =0;

    public MyhashMap(){
        this(2);
    }

    public MyhashMap(int arrayLength){
        keys = new Object[arrayLength];
        values = new Object[arrayLength];
    }



    public int size() {
        return size;
    }

    public V put(K key, V value){
        
        //key를 myhashMap에 없는 경우
        if(indexOfKey(key) == -1) {
            keys[size] = key;
            values[size] = value;
            size++;

            return null;
        }

        V beforeValue = (V)values[indexOfKey(key)];
        values[indexOfKey(key)] = value;

        return beforeValue;

    }

    public V get(K key) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey == -1) return null;

        return (V)values[indexOfKey];
    }

    private int indexOfKey(K key) {
        for(int idx = 0; idx <size;idx++){
            if(key.equals(keys[idx]))
                return idx;
        }
        return -1;
    }
}
