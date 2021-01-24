package com.sunwj.structure.setandmap;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/24 1:18 下午
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
