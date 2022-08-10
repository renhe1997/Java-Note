package com.company.LeetCode.ǰ׺��;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode1248. ͳ�ơ����������项
 * ��Ŀ����
 *
 * ����һ���������� nums ��һ������ k��
 *
 * ���ĳ�� ���� ��������ǡ���� k ���������֣����Ǿ���Ϊ����������ǡ����������项��
 *
 * �뷵����������С����������项����Ŀ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,2,1,1], k = 3
 * �����2
 * ���ͣ����� 3 ���������������� [1,1,2,1] �� [1,2,1,1] ��
 *
 * ʾ�� 2��
 *
 * ���룺nums = [2,4,6], k = 1
 * �����0
 * ���ͣ������в������κ����������Բ��������������顣
 *
 * ʾ�� 3��
 *
 * ���룺nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * �����16
 *
 */
public class NumberOfSubarrays {
    public static int numberOfSubArrays1(int[] nums,int k){
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int oddnum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j]%2!=0){
                    oddnum++;
                }
                if(k == oddnum){
                    count++;
                }
            }
        }
        return count;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddnum = 0;
        // Map<Ŀǰ���ۼ�ֵ,����>
        // ���map�д����Ӵ����ۼ�ֵ������һ�Ӵ����ۼ�ֵ
        // ʹ��odd[1]+odd[2] = k
        // ��odd[2]������count++��
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            // ����
            oddnum = oddnum+(nums[i]&1);
            // ������sum-k,��Ϊsum[i]-sum[j] = k,��֪sum[i],k�����ж�����sum[j] = sum[i]-k
            count = count+map.getOrDefault(oddnum-k,0);
            map.put(oddnum,map.getOrDefault(oddnum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k));
    }
}
