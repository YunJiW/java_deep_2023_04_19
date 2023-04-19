package com.ll.exam1;

public class MyArrayList<T> {

    private String[] data = new String[2];
    private int size = 0;
    public int size() {
        return size;
    }

    public boolean add(T element) {
        data[size] = (String)element;
        size+=1;
        return true;
    }

    public String get(int i) {
        return data[i];
    }
}
