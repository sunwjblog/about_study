package com.sunwj.structure.linkedlist;

import com.sunwj.structure.queue.ArrayQueue;
import com.sunwj.structure.queue.LoopQueue;
import com.sunwj.structure.queue.Queue;
import com.sunwj.structure.stack.ArrayStack;
import com.sunwj.structure.stack.Stack;

import java.util.Random;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/9 3:28 下午
 */
public class Main2 {

    private static double testStack(Stack<Integer> q, int op){

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < op; i++) {
            q.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < op; i++) {
            q.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> a = new ArrayStack<>();
        double time1 = testStack(a,opCount);
        System.out.println("ArrayStack,time: "+ time1 +"s");

        LinkedListStatck<Integer> l = new LinkedListStatck<>();
        double time2 = testStack(l,opCount);
        System.out.println("LinkedListStatck,time: "+ time2 +"s");
    }
}
