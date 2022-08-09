package com.company.LeetCode.前缀和;

/**
 * leetcode 724. 寻找数组的中心索引
 * 题目描述
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 *
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 *
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 *
 */
public class PivotIndex {
    /**
     * 前缀和
     * @param nums
     * @return
     */
    public static int pivotIndex(int nums[]){
        int[] frontSum = new int[nums.length];
        frontSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            frontSum[i] = frontSum[i-1]+nums[i];
        }
        // 这里不能以i=1为起点，因为会落下i=0的情况。
        for (int i = 0; i < frontSum.length; i++) {
            int leftSum = frontSum[i]-nums[i];
            int rightSum = frontSum[frontSum.length - 1] - frontSum[i];
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }
}
