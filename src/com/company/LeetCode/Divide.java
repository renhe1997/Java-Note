package com.company.LeetCode;


/**
 * ��������
 * ������������ a �� b �������ǵĳ������� a/b ��Ҫ�󲻵�ʹ�ó˺� '*'������ '/' �Լ�������� '%'?��
 * ?
 * <p>
 * ע�⣺
 * <p>
 * ���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8?�Լ�?truncate(-2.7335) = -2
 * �������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [Integer.minValue,Integer.maxValue-1]�������У�����������������򷵻� Integer.maxValue-1
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺a = 15, b = 2
 * �����7
 * ���ͣ�15/2 = truncate(7.5) = 7
 * ʾ�� 2��
 * <p>
 * ���룺a = 7, b = -3
 * �����-2
 * ���ͣ�7/-3 = truncate(-2.33333..) = -2
 * ʾ�� 3��
 * <p>
 * ���룺a = 0, b = 1
 * �����0
 * ʾ�� 4��
 * <p>
 * ���룺a = 1, b = 1
 * �����1
 * ?
 * <p>
 * ��ʾ:
 * <p>
 * Integer.minValue<= a, b <= Integer.maxValue- 1
 * b != 0
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/xoh6Oh
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * <p>
 * ˼·�����ó˳��ࡢֻ�ܼӼ���
 */
public class Divide {
    public static int divide1(int a, int b) {
        int r = 0;
        boolean flag = false;
        // ���������������֦
        if (a == 0) {
            return 0;
        }
        if (a == b) {
            return 1;
        }
        if (a + b == 0) {
            return -1;
        }
        //a/b
        // Integer.minValue<= a, b <= Integer.maxValue- 1
        // ��ֵ��Χ�� [Integer.minValue,Integer.maxValue-1]
        if (a==Integer.MIN_VALUE){
            if (b==1){
                return Integer.MIN_VALUE;
            }else if(b==-1){
                return Integer.MAX_VALUE;
            }
        }
        if (b==Integer.MIN_VALUE){
            return a==Integer.MIN_VALUE?1:0;
        }
        // ���������ȫ��תΪ����
        if ((a>0&&b>0)||(a<0&&b<0)){
            flag = true;
        }
        a = a<0?a:-a;
        b = b<0?b:-b;
        // ���ַ�������һ���ж������ж�b*mid>=a,�Ƿ����
        int left = 1;int right = Integer.MAX_VALUE;int mid = 0;
        // ȡ�м�ֵ���޷�������1����ͬ�ڳ��Զ�
        while (left<=right) {
            mid = left+((right-left)>>1);
            // ���b*mid>=a�����������������Ѱ�ҷ����������ٽ�ֵ��
            boolean isResult = quickAdd(b,mid,a);
            if (isResult){
                r = mid;
                if (mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return flag?r:-r;
    }

//    /**
//     * ����һ�����ߣ���֤mid*b>=a
//     * @param a
//     * @param mid
//     * @param b
//     * @return
//     */
//    public boolean quickAdd(int a,int mid,int b){
//
//
//
//
//
//
//
//
//
//        return false;
//    }

    // ���ٳ�
    public static boolean quickAdd(int y, int z, int x) {
        // x �� y �Ǹ�����z ������
        // ��Ҫ�ж� z * y >= x �Ƿ����
        int result = 0, add = y;
        while (z != 0) {
            // z==1
            if ((z & 1) != 0) {
                // ��Ҫ��֤ result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // ��Ҫ��֤ add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // ����ʹ�ó���
            // z = z>>1,z���Զ�
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(divide1(15,2));
    }
}
