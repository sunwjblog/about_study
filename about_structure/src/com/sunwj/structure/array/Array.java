package com.sunwj.structure.array;

import java.util.Arrays;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/3 8:37 下午
 */
public class Array<E> {

    private  E[] data;
    private  int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        this.data = (E[])new Object[capacity];
        size=0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpity(){
        return size == 0;
    }

    //末尾添加元素
    public void addLast(E e){
        add(size,e);
    }

    //在所有元素之前添加元素
    public void addFirst(E e){
        add(0,e);
    }

    //将某个元素插入到某个位置
    public void add(int index,E e) {


        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.index error.");

        if (size == data.length)
            resize(2 * data.length);

        //元素全部后移，移动方式是从后往前的方式移动
        for (int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    //扩容
    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;

    }


    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get failed.index error.");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }


    public void set(int index,E e){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("get failed.index error.");

        data[index] = e;
    }

    public boolean contains(E e){
        for (int i = 0; i < size; i++){
            if(data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for (int i = 0; i < size; i++){
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("remove failed.index error.");

        E ret = data[index];
        for (int i = index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;

        if(size == data.length / 2)
            resize(data.length / 2);

        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

}
