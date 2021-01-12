package com.sunwj.structure.linkedlist;

import com.sunwj.structure.stack.Stack;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 7:44 下午
 */
public class LinkedListStatck<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStatck() {
        list = new LinkedList<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
