package com.company.LeetCode.ǰ׺��;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 523 �������������
 * ��Ŀ����
 *
 * ����һ������ �Ǹ��� �������һ��Ŀ�� ���� k��
 * ��дһ���������жϸ������Ƿ��������������飬
 * ���С����Ϊ 2�����ܺ�Ϊ k �ı��������ܺ�Ϊ n*k������ n Ҳ��һ��������
 *
 * ʾ�� 1��
 *
 * ���룺[23,2,4,6,7], k = 6
 * �����True
 *
 * ���ͣ�[2,4] ��һ����СΪ 2 �������飬���Һ�Ϊ 6��
 *
 * ʾ�� 2��
 *
 * ���룺[23,2,6,4,7], k = 6
 * �����True
 *
 * ���ͣ�[23,2,6,4,7]�Ǵ�СΪ 5 �������飬���Һ�Ϊ 42��
 *
 */
public class CheckSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        // ��Ϊvalue��������������Ǵ��������Ϊ1�����©��01���������������Ϊ-1,1-(-1)=2����������
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            int s = (sum%k+k)%k;
            if (map.containsKey(s)){
                if (i-map.get(s)>1) {
                    return true;
                }
                // �����������������ǲ�����������ڵ���2����������Ҳ���������ֵ
                // ������£������֣���12��23ͬ�࣬������ֵΪ3����34�������������������ֵΪ3����©����
                continue;
            }
            map.put(s,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums,k));
    }
}
