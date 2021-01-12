package com.sunwj.structure.queue;

import java.util.Random;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/9 3:28 下午
 */
public class Main {

    private static double testQueue(Queue<Integer> q,int op){

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < op; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < op; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> a = new ArrayQueue<>();
        double time1 = testQueue(a,opCount);
        System.out.println("ArrayQueue,time: "+ time1 +"s");

        LoopQueue<Integer> l = new LoopQueue<>();
        double time2 = testQueue(l,opCount);
        System.out.println("LoopQueue,time: "+ time2 +"s");

        LInkedListQueue<Integer> l1 = new LInkedListQueue<>();
        double time3 = testQueue(l1,opCount);
        System.out.println("LInkedListQueue,time: "+ time3 +"s");
    }
}
