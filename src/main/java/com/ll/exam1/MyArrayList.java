package com.ll.exam1;

public class MyArrayList<T> {

    private String[] data = new String[2];
    private int size = 0;
    public int size() {
        return size;
    }

    public boolean add(T element) {

        makeNewDataIfNotEnough();
        data[size] = (String)element;
        size+=1;
        return true;
    }

    private void makeNewDataIfNotEnough() {
        if(ifNotEnough())
        {
            makeNewData();
        }
    }

    private void makeNewData() {
        //2배로 늘려서 새로 생성
        String[] newData = new String[data.length *2];

        for(int idx = 0; idx < data.length;idx++)
        {
            newData[idx] = data[idx];
        }

        data = newData;
    }

    private boolean ifNotEnough() {
        return  size >= data.length;
    }

    public String get(int i) {
        return data[i];
    }
}
