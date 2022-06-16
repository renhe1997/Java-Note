package com.company.LeetCode.Array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * @Author: RenHe
 * @Date: 2021/6/15 9:16
 */
public class SearchInsert {
    private static int[] nums = {1,3,5,7,8};
    public static void main(String[] args) {
        int index = searchInsertOne(9);
        System.out.println(index);
    }

    /**
     * 暴力解法
     */
    public static int searchInsertOne(int num){
        if (nums[0]>num){
            return 0;
        }
        if (nums[nums.length-1]<num){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=num){
                return i;
            }
        }
        return 0;
    }
    /**
     * 二分法
     */
//    public static int searchInsertTwo(int num){
//        int left = 0;
//        int right = nums.length;
//        while (left<=right){
//            int middle = (left+right)/2;
//            if ()
//        }














//
//
//        return 0;
//    }
//



















}
