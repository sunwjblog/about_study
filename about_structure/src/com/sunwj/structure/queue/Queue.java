package com.sunwj.structure.queue;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/7 7:26 下午
 */
public interface Queue<E> {

    int getSize();      //O(1)

    boolean isEmpty();  //O(n)

    void enqueue(E e);  //O(1)

    E dequeue();        //O(1)

    E getFront();       //O(1)
}
