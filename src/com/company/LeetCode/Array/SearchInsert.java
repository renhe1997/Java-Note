package com.company.LeetCode.Array;

/**
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 * ����Լ������������ظ�Ԫ�ء�
 * @Author: RenHe
 * @Date: 2021/6/15 9:16
 */
public class SearchInsert {
    private static int[] nums = {1,3,5,7,8};
    public static void main(String[] args) {
        int index = searchInsertOne(9);
        System.out.println(index);
    }

    /**
     * �����ⷨ
     */
    public static int searchInsertOne(int num){
        if (nums[0]>num){
            return 0;
        }
        if (nums[nums.length-1]<num){
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=num){
                return i;
            }
        }
        return 0;
    }
    /**
     * ���ַ�
     */
//    public static int searchInsertTwo(int num){
//        int left = 0;
//        int right = nums.length;
//        while (left<=right){
//            int middle = (left+right)/2;
//            if ()
//        }














//
//
//        return 0;
//    }
//



















}
