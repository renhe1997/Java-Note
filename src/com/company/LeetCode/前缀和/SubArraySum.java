package com.company.LeetCode.ǰ׺��;

import com.company.DataStructure.Collection.Map.HashMap.HashMapLearn;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560. ��ΪK��������
 * ��Ŀ����
 *
 * ����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
 *
 * ʾ�� 1 :
 *
 * ����:nums = [1,1,1], k = 2
 * ���: 2 , [1,1] �� [1,1] Ϊ���ֲ�ͬ�������
 *
 */
public class SubArraySum {
    /**
     * �����ⷨ
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum+nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ǰ׺��+HashMap
     * ��֪sum[i] = sum[i-1]+nums[i]
     * �������һ����ǰ׺�� = k
     * ��������sum[i]-sum[j] = k
     * ��������sum[j]=sum[i]-k
     * w����ת��Ϊ���Ƿ�ͬʱ����sum[i],sum[j],ʹ��sum[i]-sum[j] = k
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        // �����һ��Ԫ�ط���������num[0]=num[0]+0=sum=k,��ʱhashMap����ֵ������������Ԥ�ȷ�ֹ
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            if(map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum1(new int[]{1,2,3},3));
    }
}
