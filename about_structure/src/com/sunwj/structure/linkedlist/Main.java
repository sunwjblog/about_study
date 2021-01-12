package com.sunwj.structure.linkedlist;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 7:08 下午
 */
public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList.toString());
        }

        linkedList.add(2,666);
        System.out.println(linkedList.toString());

        linkedList.remove(2);
        System.out.println(linkedList.toString());

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
