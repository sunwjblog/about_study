package com.sunwj.structure.setandmap;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/23 9:48 下午
 */
public interface Set<E>{

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
