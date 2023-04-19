package com.ll.exam1;

public class MyArrayList<T> {

    private int size = 0;
    public int size() {
        return size;
    }

    public boolean add(T element) {
        size+=1;
        return true;
    }
}
