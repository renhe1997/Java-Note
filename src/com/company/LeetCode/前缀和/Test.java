package com.company.LeetCode.Ç°×ººÍ;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,0};
        int[] frontSum = new int[10];
        frontSum[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            frontSum[i] = frontSum[i-1]+nums[i];
        }
        System.out.println(Arrays.toString(frontSum));






    }
}
