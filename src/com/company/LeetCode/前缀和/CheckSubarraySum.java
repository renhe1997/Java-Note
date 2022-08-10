package com.company.LeetCode.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 523 连续的子数组和
 * 题目描述
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k，
 * 编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 *
 * 示例 1：
 *
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 *
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 *
 * 示例 2：
 *
 * 输入：[23,2,6,4,7], k = 6
 * 输出：True
 *
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 */
public class CheckSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        // 因为value存的是索引，而非次数，如果为1，则会漏掉01满足条件的情况，为-1,1-(-1)=2，满足条件
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            int s = (sum%k+k)%k;
            if (map.containsKey(s)){
                if (i-map.get(s)>1) {
                    return true;
                }
                // 符合整除条件，但是不满足数组大于等于2，则继续，且不更新索引值
                // 如果更新，则会出现，当12与23同余，存索引值为3，而34本满足条件，因存索引值为3而被漏掉。
                continue;
            }
            map.put(s,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums,k));
    }
}
