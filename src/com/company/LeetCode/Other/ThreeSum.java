package com.company.LeetCode.Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��
 * @Author: RenHe
 * @Date: 2021/5/13 9:04
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,0,1,3,3,2,6};
        System.out.println(getThreeSum(nums).toString());
    }
    public static List<List> getThreeSum(int[] nums){
        List<List> resultList = new ArrayList();
        //����
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                break;
            }
            // �ų��ظ�Ԫ��
            while(i<nums.length-2&&nums[i]==nums[i+1]){
                i++;
            }
            for(int j=i+1,k=nums.length-1;j<k;j++){
                int tempSum = nums[i]+nums[j]+nums[k];
                if (tempSum == 0){
                    resultList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    // �ų��ظ�Ԫ��
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



























