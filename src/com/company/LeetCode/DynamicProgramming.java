package com.company.LeetCode;

/**
 * @Author: RenHe
 * @Date: 2021/3/1 14:19
 */

/**
 * 动态规划
 *
 * 最优子结构、状态转移方程和边界
 */
public class DynamicProgramming {
    /**
     *  * 一个楼梯有 10 级台阶，你从下往上走，每跨一步只能向上迈 1 级或者 2 级台阶，请问一共有多少种走法
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
        // 从123推过来，时间复杂度小，少算一遍
        for(int i=3;i<=n;i++){
            step = a+b;
            a = b;
            b  = step;
        }
        // 直接递归，时间复杂度为平方，因为f(10)=f(9)+f(8),f(9)=f(8)+f(7),f(8)=f(7)+f(6),f(4)=f(3)+f(2)=f(2)+f(1)+f(2)
        // step = getStep(n-1)+getStep(n-2);
        return step;
    }

    /**
     * 有一个背包，可以装载重量为 5kg 的物品。有4个物品,物品的(质量,价值)分别为(1,3)(2,4)(3,5)(4,6),求价值最大的利用方案
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
        System.out.println("总方法共"+ step +"种");
    }
}
