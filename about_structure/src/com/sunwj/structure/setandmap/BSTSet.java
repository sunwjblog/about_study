package com.sunwj.structure.setandmap;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/23 9:50 下午
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private BST<E> bst;

    public BSTSet(){
        bst = new BST<E>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
