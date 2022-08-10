package com.company.LeetCode.ǰ׺��;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָ Offer II 011. 0 �� 1 ������ͬ��������
 * ����һ������������ nums , �ҵ�������ͬ������ 0 �� 1 ������������飬�����ظ�������ĳ��ȡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: nums = [0,1]
 * ���: 2
 * ˵��: [0, 1] �Ǿ�����ͬ���� 0 �� 1 ������������顣
 * ʾ�� 2��
 *
 * ����: nums = [0,1,0]
 * ���: 2
 * ˵��: [0, 1] (�� [1, 0]) �Ǿ�����ͬ���� 0 �� 1 ������������顣
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 105
 * nums[i] ���� 0 ���� 1
 */
public class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            int num = 1;
            if (nums[i]==0){
                num = -1;
            }
            sum = sum+num;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength,i-map.get(sum));
            }
            map.put(sum,map.containsKey(sum)?map.get(sum):i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
}
