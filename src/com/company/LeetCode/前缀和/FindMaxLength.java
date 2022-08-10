package com.company.LeetCode.前缀和;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 */
public class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            int num = 1;
            if (nums[i]==0){
                num = -1;
            }
            sum = sum+num;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength,i-map.get(sum));
            }
            map.put(sum,map.containsKey(sum)?map.get(sum):i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
}
