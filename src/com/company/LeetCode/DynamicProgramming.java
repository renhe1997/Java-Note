package com.company.LeetCode;

/**
 * @Author: RenHe
 * @Date: 2021/3/1 14:19
 */

/**
 * ��̬�滮
 *
 * �����ӽṹ��״̬ת�Ʒ��̺ͱ߽�
 */
public class DynamicProgramming {
    /**
     *  * һ��¥���� 10 ��̨�ף�����������ߣ�ÿ��һ��ֻ�������� 1 ������ 2 ��̨�ף�����һ���ж������߷�
     *  * result 89
     * @param n
     * @return
     */
    public int getStep(int n){
        int step = 0;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int a=1;
        int b=2;
        // ��123�ƹ�����ʱ�临�Ӷ�С������һ��
        for(int i=3;i<=n;i++){
            step = a+b;
            a = b;
            b  = step;
        }
        // ֱ�ӵݹ飬ʱ�临�Ӷ�Ϊƽ������Ϊf(10)=f(9)+f(8),f(9)=f(8)+f(7),f(8)=f(7)+f(6),f(4)=f(3)+f(2)=f(2)+f(1)+f(2)
        // step = getStep(n-1)+getStep(n-2);
        return step;
    }

    /**
     * ��һ������������װ������Ϊ 5kg ����Ʒ����4����Ʒ,��Ʒ��(����,��ֵ)�ֱ�Ϊ(1,3)(2,4)(3,5)(4,6),���ֵ�������÷���
     * @return
     */
    public int getFunctions2(int maxValue){
        int thisSumValue = 0;
        for(int i=0; i<4; i++){

        }
        if(maxValue<thisSumValue){
            maxValue = thisSumValue;
        }




        return 0;
    }























    public static void main(String[] args) {
        int step = new DynamicProgramming().getStep(10);
        System.out.println("�ܷ�����"+ step +"��");
    }
}
