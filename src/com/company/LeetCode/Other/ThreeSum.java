package com.company.LeetCode.Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @Author: RenHe
 * @Date: 2021/5/13 9:04
 */
public class ThreeSum {
    public static void main(String[] args) {
//        int[] nums = {-2,-1,-1,0,1,3,3,2,6};
//        int[] nums = {0,0,0,0};
        int[] nums ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List resultList =  new ArrayList();
        for(int i = 0;i<nums.length-2;i++){
            if (nums[i]>0){
                break;
            }
            //需要和上一次枚举的数不相同,-1取上次
            if (i>0&&(nums[i]==nums[i-1])){
                continue;
            }
            int one = -nums[i];
            int first = i+1;
            int second = nums.length-1;
            while(first<second){
                if((nums[first]+nums[second])<one){
                    first++;
                }else if((nums[first]+nums[second])>one){
                    second--;
                }else{
                    while(first<second&&nums[first]==nums[first+1]){
                        first++;
                    }
                    while(first<second&&nums[second]==nums[second-1]){
                        second--;
                    }
                    List intList = new ArrayList();
                    intList.add(nums[i]);
                    intList.add(nums[first]);
                    intList.add(nums[second]);
                    resultList.add(intList);
                    // 这里不能结束循环，因为可能存在多个组合使得(nums[first]+nums[second])=one，所以应该挪移指针，继续循环。
                    first++;second--;
                    continue;
                }
            }
        }

        return resultList;
    }

    public static List<List> getThreeSum(int[] nums){
        List<List> resultList = new ArrayList();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            // 排除重复元素
            while(i<nums.length-2&&nums[i]==nums[i+1]){
                i++;
            }
            for(int j=i+1,k=nums.length-1;j<k;j++){
                int tempSum = nums[i]+nums[j]+nums[k];
                if (tempSum == 0){
                    resultList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // 排除重复元素
                    while(j<k&&nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k&&nums[k]==nums[k-1]){
                        k--;
                    }
                    k = nums.length-1;
                    continue;
                }else if (tempSum>0){
                    k--;j--;continue;
                }else if (tempSum<0){
                    k = nums.length-1;
                    break;
                }
            }
        }
        return resultList;
    }

























}



























