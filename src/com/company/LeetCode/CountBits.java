package com.company.LeetCode;

public class CountBits {
    /**
     * ��ָ Offer II 003. ǰ n �����ֶ������� 1 �ĸ���
     * ����һ���Ǹ����� n ������� 0 �� n ֮���ÿ�����ֵĶ����Ʊ�ʾ�� 1 �ĸ����������һ�����顣
     *
     *
     *
     * ʾ�� 1:
     *
     * ����: n = 2
     * ���: [0,1,1]
     * ����:
     * 0 --> 0
     * 1 --> 1
     * 2 --> 10
     * @param a
     * @return
     *
     * ˵�� :
     *
     * 0 <= n <= 105
     * ?
     *
     * ����:
     *
     * ����ʱ�临�Ӷ�Ϊ?O(n*sizeof(integer))?�Ľ��ǳ����ס��������������ʱ��?O(n)?����һ��ɨ��������
     * Ҫ���㷨�Ŀռ临�Ӷ�Ϊ?O(n)?��
     * ���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е�?__builtin_popcount?����ִ�д˲�����
     */
    public static int[] countBits(int n){
        // ����� 0 �� n ֮���ÿ�����ֵĶ����Ʊ�ʾ�� 1 �ĸ���
        int[] bytes = new int[n+1];
        for (int i = 0; i <= n; i++) {
            bytes[i] = getCount(i);
        }
        return bytes;
    }

    private static int getCount(int i) {
        int count = 0;
        while (i!=0){
            i = i&(i-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }

}
