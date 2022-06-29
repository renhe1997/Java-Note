package com.company.LeetCode.Other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 001 两数之和
 * @Author: RenHe
 * @Date: 2021/5/11 17:42
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] f = {1,3,5,6,2};
        int targetNum = 8;
        System.out.println(Arrays.toString(twoSum(f,targetNum)));
//        System.out.println(getTwoSum(f,targetNum).toString());
    }
    public static int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length-1;
        while(first<second){
            if((numbers[first]+numbers[second])<target){
                first++;
            }else if((numbers[first]+numbers[second])>target){
                second--;
            }else{
                break;
            }
        }
        return new int[]{first,second};
    }



    public static Map getTwoSum(int[] f, int targetNum){
        // ｛数，和-数的差｝
        Map dataMap  = new HashMap();
        // ｛数1，数2｝
        Map resultMap  = new HashMap();
        for (int i = 0; i <f.length ; i++) {
            dataMap.put(f[i],targetNum-f[i]);
        }
        for (int i = 0; i < f.length; i++) {
            // 防止出现{1,2}{2,1}的情况
            if (dataMap.containsValue(f[i])&&!resultMap.containsValue(f[i])){
                resultMap.put(f[i],targetNum-f[i]);
            }
        }
        return resultMap;
    }
}
























