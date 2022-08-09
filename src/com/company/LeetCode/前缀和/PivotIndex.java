package com.company.LeetCode.ǰ׺��;

/**
 * leetcode 724. Ѱ���������������
 * ��Ŀ����
 *
 * ����һ���������͵����� nums�����дһ���ܹ��������� ������������ �ķ�����
 *
 * ������������������ �������� �ģ����������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
 *
 * ������鲻����������������ô����Ӧ�÷��� -1����������ж��������������ô����Ӧ�÷��������ߵ���һ����
 *
 * ʾ�� 1��
 *
 * ���룺
 * nums = [1, 7, 3, 6, 5, 6]
 * �����3
 *
 * ���ͣ�
 * ���� 3 (nums[3] = 6) �������֮�� (1 + 7 + 3 = 11)�����Ҳ���֮�� (5 + 6 = 11) ��ȡ�
 * ͬʱ, 3 Ҳ�ǵ�һ������Ҫ�������������
 *
 * ʾ�� 2��
 *
 * ���룺
 * nums = [1, 2, 3]
 * �����-1
 *
 */
public class PivotIndex {
    /**
     * ǰ׺��
     * @param nums
     * @return
     */
    public static int pivotIndex(int nums[]){
        int[] frontSum = new int[nums.length];
        frontSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            frontSum[i] = frontSum[i-1]+nums[i];
        }
        // ���ﲻ����i=1Ϊ��㣬��Ϊ������i=0�������
        for (int i = 0; i < frontSum.length; i++) {
            int leftSum = frontSum[i]-nums[i];
            int rightSum = frontSum[frontSum.length - 1] - frontSum[i];
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        System.out.println(pivotIndex(nums));
    }
}
