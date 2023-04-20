package com.ll.exam1;

import java.util.function.Predicate;

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
    public boolean add(int index,T element) {

        makeNewDataIfNotEnough();

        makeEmptyIndex(index);

        data[index] = element;
        size+=1;

        return true;
    }

    private void makeEmptyIndex(int index) {
        for(int idx =size-1; idx >= index ; idx--){
            data[idx+1] =data[idx];
        }
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

    public int indexOf(T element) {
        for(int idx =0; idx <size;idx++){
            if(data[idx].equals(element)){
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
    public void removeIf(Predicate<T> predicate) {
        int i = 0;
        for (int j = 0; j < size; j++) {
            if (!predicate.test((T)data[j])) {
                data[i++] = data[j];
            }
        }
        size = i;
    }

    public void set(int index, T element) {
        data[index] = element;
    }
}
