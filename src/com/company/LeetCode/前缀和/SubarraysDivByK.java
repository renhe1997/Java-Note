package com.company.LeetCode.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 974 和可被 K 整除的子数组
 * 题目描述
 *
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 *
 * 解释：
 *
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 */
public class SubarraysDivByK {
    public static int subarraysDivByK(int[] nums,int k) {
        int count = 0;
        int sum = 0;
        // Map<目前的累加值,次数>
        Map<Object, Integer> map = new HashMap();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            int s = (sum%k+k)%k;
            count = count + map.getOrDefault(s, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,9};
        int k = 2;
        System.out.println(subarraysDivByK(nums,k));
    }
}
