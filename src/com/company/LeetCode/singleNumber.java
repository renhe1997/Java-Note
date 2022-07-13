package com.company.LeetCode;

import java.util.*;

public class singleNumber {
    // 剑指 Offer II 004. 只出现一次的数字
    //给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,2,3,2]
    //输出：3
    //示例 2：
    //
    //输入：nums = [0,1,0,1,0,1,100]
    //输出：100
    //
    //
    //提示：
    //
    //1 <= nums.length <= 3 * 10 4
    //-2 31 <= nums[i] <= 2 31 - 1
    //nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
    //
    //
    //进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    public static int singleNumber(int[] nums) {
        int num = 0;
        Map<Integer,Integer> countMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i],countMap.get(nums[i])==null?1:countMap.get(nums[i])+1);
        }
        Iterator iterator = countMap.keySet().iterator();
        while (iterator.hasNext()){
            int key = (int) iterator.next();
            if (countMap.get(key)==1){
                num = key;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,3,2,3};
        System.out.println(singleNumber(nums));

    }




}
