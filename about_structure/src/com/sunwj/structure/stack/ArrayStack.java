package com.sunwj.structure.stack;

import com.sunwj.structure.array.Array;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/6 11:42 下午
 */
public class ArrayStack <E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpity();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if( i != array.getSize() - 1 )
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
