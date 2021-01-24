package com.sunwj.structure.setandmap;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/10 6:08 下午
 */
public class LinkedList<E> {

    private class Node{
        E e;
        Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedList(){
        this.dummyHead = new Node(null,null);
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    //在链表的index(0-based)位置添加新的元素e
    //在链表中不是一个常用的操作。
    public void add(int index,E e) { //O(n)

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");


            Node prev = dummyHead;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

           /* Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;*/

            prev.next = new Node(e,prev.next);

            size ++;

    }

    //在链表头添加新的元素e
    public void addFirst(E e) { //O(1)

        //方式1
       /* Node node = new Node(e);
        node.next = head;
        head = node;*/

        //方式2 同方式1 效果想同
        add(0,e);

        //size ++;
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) { //O(n)
        add(size,e);
    }

    //获取链表中的元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取头节点元素
    public E getFirst() {
        return get(0);
    }

    //获取末尾节点元素
    public E getLast() {
        return get(size-1);
    }

    //修改链表元素内容
    public void set(int index, E e){ // O(n)
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除
    public E remove(int index) { //O(n)
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed,Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst() { //O(1)
        return remove(0);
    }

    public E removeLast() { // O(n)
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }

        /*for (Node cur = dummyHead.next;  cur != null ; cur = cur.next) {
            res.append(cur + "->");
        }*/
        res.append("NULL");
        return res.toString();
    }
}
