package com.sunwj.structure.setandmap;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/24 2:21 下午
 */
public interface Map<K,V> {

    void add(K key,V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key,V newValue);

    int getSize();

    boolean isEmpty();

}
