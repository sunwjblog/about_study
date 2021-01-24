package com.sunwj.structure.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author sunwjcoder
 * @version 1.0
 * @description
 * @date 2021/1/19 11:24 下午
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());

        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) > nums.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("removeMin test completed.");
//        int[] nums = {5,3,6,8,4,2};
//        for (int num : nums)
//            bst.add(num);

//        bst.preOrder();
//
//        System.out.println();
//
//        bst.preOrderNR();
//
//        System.out.println();

//        bst.levelOrder();

        //bst.afOrder();
        //System.out.println(bst);
    }
}
