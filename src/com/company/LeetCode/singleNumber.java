package com.company.LeetCode;

import java.util.*;

public class singleNumber {
    // ��ָ Offer II 004. ֻ����һ�ε�����
    //����һ���������� nums ����ĳ��Ԫ�ؽ����� һ�� �⣬����ÿ��Ԫ�ض�ǡ���� ���� �������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
    //
    //
    //
    //ʾ�� 1��
    //
    //���룺nums = [2,2,3,2]
    //�����3
    //ʾ�� 2��
    //
    //���룺nums = [0,1,0,1,0,1,100]
    //�����100
    //
    //
    //��ʾ��
    //
    //1 <= nums.length <= 3 * 10 4
    //-2 31 <= nums[i] <= 2 31 - 1
    //nums �У���ĳ��Ԫ�ؽ����� һ�� �⣬����ÿ��Ԫ�ض�ǡ���� ����
    //
    //
    //���ף�����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
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
