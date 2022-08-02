package com.company.LeetCode.前缀和;

import com.company.DataStructure.Collection.Map.HashMap.HashMapLearn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560. 和为K的子数组
 * 题目描述
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 */
public class SubArraySum {
    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum+nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和+HashMap
     * 已知sum[i] = sum[i-1]+nums[i]
     * 欲求存在一段子前缀和 = k
     * 即，存在sum[i]-sum[j] = k
     * 即，存在sum[j]=sum[i]-k
     * w问题转化为，是否同时存在sum[i],sum[j],使得sum[i]-sum[j] = k
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        // 如果第一个元素符合条件，num[0]=num[0]+0=sum=k,此时hashMap里无值，会错过，所以预先防止
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{1,2,3},3));
    }
}
