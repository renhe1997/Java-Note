package com.company.LeetCode.Other;

import java.util.HashMap;
import java.util.Map;

/**
 * 001 ����֮��
 * @Author: RenHe
 * @Date: 2021/5/11 17:42
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] f = {1,3,5,6,2};
        int targetNum = 8;
        System.out.println(getTwoSum(f,targetNum).toString());
    }
    public static Map getTwoSum(int[] f, int targetNum){
        // ��������-���Ĳ��
        Map dataMap  = new HashMap();
        // ����1����2��
        Map resultMap  = new HashMap();
        for (int i = 0; i <f.length ; i++) {
            dataMap.put(f[i],targetNum-f[i]);
        }
        for (int i = 0; i < f.length; i++) {
            // ��ֹ����{1,2}{2,1}�����
            if (dataMap.containsValue(f[i])&&!resultMap.containsValue(f[i])){
                resultMap.put(f[i],targetNum-f[i]);
            }
        }
        return resultMap;
    }
}
























