package com.ll.exam1.MyHashMap;

import java.util.HashMap;

public class MyhashMap<K,V> {

    private Entry[] entries;

    private int size =0;

    public void clear() {
        for(int idx= 0; idx <size;idx++){
            entries[idx] = null;
        }
        size = 0;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }


    private static class Entry<K,V>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value =value;
        }

    }



    public MyhashMap(){
        this(2);
    }

    public MyhashMap(int arrayLength){
        entries = new Entry[arrayLength];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value){

        //충분한지 체크
        isEnoughSize();
        int indexOfKey = indexOfKey(key);
        //key를 myhashMap이 가지고 있지 않은 경우
        if(indexOfKey == -1) {
            entries[size] = new Entry<>(key,value);
            size++;

            return null;
        }
        


        return (V)entries[indexOfKey].value;
    }

    private void isEnoughSize() {
        if(isfull()){
            ExtenseEntry();
        }
    }

    private void ExtenseEntry() {
        Entry[] newEntries = new Entry[entries.length*2];

        for(int idx = 0; idx < entries.length;idx++)
        {
            newEntries[idx] = entries[idx];
        }
        entries = newEntries;
    }

    private boolean isfull() {
        if(size >= entries.length)
            return true;

        return false;
    }

    public V remove(K key) {
        int indexOfKey = indexOfKey(key);


        if(indexOfKey == -1) return null;

        V removeValue = (V)entries[indexOfKey].value;
        for(int idx= indexOfKey; idx <size-1;idx++){
            entries[idx] = entries[idx+1];
        }
        entries[size-1] = null;

        size-=1;
        return removeValue;

    }

    public V get(K key) {
        int indexOfKey = indexOfKey(key);

        if(indexOfKey == -1) return null;

        return (V)entries[indexOfKey].value;
    }

    public boolean containsKey(K key) {
        if(indexOfKey(key) != -1){
            return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if(indexOfValue(value) == -1)
            return false;

        return true;
    }

    private int indexOfValue(V value) {
        for(int idx = 0; idx <size;idx++){
            if(value.equals(entries[idx].value))
                return idx;
        }
        return -1;
    }


    private int indexOfKey(K key) {
        for(int idx = 0; idx <size;idx++){
            if(key.equals(entries[idx].key))
                return idx;
        }
        return -1;
    }

}
