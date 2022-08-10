package com.company.LeetCode.前缀和;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode1248. 统计「优美子数组」
 * 题目描述
 *
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 */
public class NumberOfSubarrays {
    public static int numberOfSubArrays1(int[] nums,int k){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int oddnum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]%2!=0){
                    oddnum++;
                }
                if(k == oddnum){
                    count++;
                }
            }
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddnum = 0;
        // Map<目前的累加值,次数>
        // 如果map中存在子串的累加值，与另一子串的累加值
        // 使得odd[1]+odd[2] = k
        // 则odd[2]成立，count++；
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            // 奇数
            oddnum = oddnum+(nums[i]&1);
            // 这里是sum-k,因为sum[i]-sum[j] = k,已知sum[i],k，则判断有无sum[j] = sum[i]-k
            count = count+map.getOrDefault(oddnum-k,0);
            map.put(oddnum,map.getOrDefault(oddnum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
