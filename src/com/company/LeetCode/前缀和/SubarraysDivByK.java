package com.company.LeetCode.ǰ׺��;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 974 �Ϳɱ� K ������������
 * ��Ŀ����
 *
 * ����һ���������� A����������Ԫ��֮�Ϳɱ� K �����ģ��������ǿգ����������Ŀ��
 *
 * ʾ����
 *
 * ���룺A = [4,5,0,-2,-3,1], K = 5
 * �����7
 *
 * ���ͣ�
 *
 * �� 7 ��������������Ԫ��֮�Ϳɱ� K = 5 ������
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 */
public class SubarraysDivByK {
    public static int subarraysDivByK(int[] nums,int k) {
        int count = 0;
        int sum = 0;
        // Map<Ŀǰ���ۼ�ֵ,����>
        Map<Object, Integer> map = new HashMap();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            int s = (sum%k+k)%k;
            count = count + map.getOrDefault(s, 0);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {-1,2,9};
        int k = 2;
        System.out.println(subarraysDivByK(nums,k));
    }
}
