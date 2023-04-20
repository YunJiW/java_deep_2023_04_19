package com.ll.exam1;

public class MyArrayList<T> {

    private String[] data;
    private int size = 0;
    public int size() {
        return size;
    }

    public MyArrayList() {
        data = new String[2];
    }

    public MyArrayList(int dataLength){
        data = new String[dataLength];
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
        String[] newData;
        if(data.length != 0) {
            //2배로 늘려서 새로 생성
            newData= new String[data.length * 2];
        }else {
            newData = new String[50];
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

    public int indexOf(String element1) {
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
