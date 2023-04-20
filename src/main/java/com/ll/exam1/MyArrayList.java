package com.ll.exam1;

public class MyArrayList<T> {

    private Object[] data;
    private int size = 0;
    public int size() {
        return size;
    }

    public MyArrayList() {
        data = new Object[2];
    }

    public MyArrayList(int dataLength){
        data = new Object[dataLength];
    }

    public boolean add(T element) {

        makeNewDataIfNotEnough();
        data[size] = (T) element;
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
        Object[] newData;
        if(data.length != 0) {
            //2배로 늘려서 새로 생성
            newData= new Object[data.length * 2];
        }else {
            newData = new Object[2];
        }

        for(int idx = 0; idx < data.length;idx++)
        {
            newData[idx] = data[idx];
        }

        data = newData;
    }

    private boolean ifNotEnough() {
        return  size >= data.length;
    }

    public T get(int i) {
        return (T)data[i];
    }

    public T remove(int i) {
        T remove_data = (T)data[i];
        for(int idx = i; idx < size-1;idx++){
            data[idx] = data[i+1];
        }
        //배열의 크기는 줄지 않고 내가 쓰고있는 size를 줄인다.
        size-=1;

        return remove_data;
    }


    public boolean contains(T element) {
        for(int idx =0; idx < size;idx++) {
            if(data[idx].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element1) {
        for(int idx =0; idx <size;idx++){
            if(data[idx].equals(element1)){
                return idx;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
        data = new String[size];
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
}
