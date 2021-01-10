package com.sunwj.structure.stack;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/6 11:41 下午
 */
public interface Stack <E>{

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
