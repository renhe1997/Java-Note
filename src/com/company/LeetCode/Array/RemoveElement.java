package com.company.LeetCode.Array;

import java.util.Arrays;

/**
 * ÒÆ³ıÊı×éÔªËØ
 * @Author: RenHe
 * @Date: 2021/6/9 10:18
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {2,4,1,3,7,2};
        removeElement(nums,1);
    }
    public static int[] removeElement(int[] nums,int val){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[j] = nums[i];
                j++;
            }
        }
        return nums;
    }

    public int[] remove(int[] nums,int val){
        int j = 0;
        for (int i = 0; j < nums.length; i++) {
            if(nums[i]==val){
                j = i;
            }
            nums[j] = nums[j+1];
            j++;
        }



















        return nums;
    }
}
