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

    //배열이 충분한지 체크
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

    public String remove(int i) {
        String remove_data = data[i];
        for(int idx = i; idx < size-1;idx++){
            data[idx] = data[i+1];
        }
        //배열의 크기는 줄지 않고 내가 쓰고있는 size를 줄인다.
        size-=1;

        return remove_data;
    }


    public boolean contains(String element) {
        for(int idx =0; idx < size;idx++) {
            if(data[idx].equals(element)){
                return true;
            }
        }
        return false;
    }
}
