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
            //��Ҫ����һ��ö�ٵ�������ͬ,-1ȡ�ϴ�
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
                    // ���ﲻ�ܽ���ѭ������Ϊ���ܴ��ڶ�����ʹ��(nums[first]+nums[second])=one������Ӧ��Ų��ָ�룬����ѭ����
                    first++;second--;
                    continue;
                }
            }
        }

        return resultList;
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



























