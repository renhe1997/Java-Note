package com.company.LeetCode.ǰ׺��;

import java.util.HashMap;
import java.util.Map;

/**
 * 930. ����ͬ�Ķ�Ԫ������
 * ����һ����Ԫ���� nums ����һ������ goal ������ͳ�Ʋ������ж��ٸ���Ϊ goal �� �ǿ� �����顣
 *
 * ������ �������һ���������֡�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,0,1,0,1], goal = 2
 * �����4
 * ���ͣ�
 * �� 4 ��������ĿҪ��������飺[1,0,1]��[1,0,1,0]��[0,1,0,1]��[1,0,1]
 * ʾ�� 2��
 *
 * ���룺nums = [0,0,0,0,0], goal = 0
 * �����15
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] ���� 0 ���� 1
 * 0 <= goal <= nums.length
 */
public class NumSubarraysWithSum {
    /**
     * ǰ׺��+hashMap
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum+nums[i];
            count = count + map.getOrDefault(sum-goal,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }


    public static void main(String[] args) {
       int[] nums = {1,0,1,0,1};
       int goal = 2;
        System.out.println(numSubarraysWithSum(nums,goal));
    }
}
