package com.company.LeetCode;


/**
 * 整数求商
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%'?。
 * ?
 * <p>
 * 注意：
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8?以及?truncate(-2.7335) = -2
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [Integer.minValue,Integer.maxValue-1]。本题中，如果除法结果溢出，则返回 Integer.maxValue-1
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 15, b = 2
 * 输出：7
 * 解释：15/2 = truncate(7.5) = 7
 * 示例 2：
 * <p>
 * 输入：a = 7, b = -3
 * 输出：-2
 * 解释：7/-3 = truncate(-2.33333..) = -2
 * 示例 3：
 * <p>
 * 输入：a = 0, b = 1
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：a = 1, b = 1
 * 输出：1
 * ?
 * <p>
 * 提示:
 * <p>
 * Integer.minValue<= a, b <= Integer.maxValue- 1
 * b != 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xoh6Oh
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：不让乘除余、只能加减法
 */
public class Divide {
    public static int divide1(int a, int b) {
        int r = 0;
        boolean flag = false;
        // 过滤特殊情况，剪枝
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
        // 数值范围是 [Integer.minValue,Integer.maxValue-1]
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
        // 标记正负，全部转为负数
        if ((a>0&&b>0)||(a<0&&b<0)){
            flag = true;
        }
        a = a<0?a:-a;
        b = b<0?b:-b;
        // 二分法，构造一个判断器，判断b*mid>=a,是否成立
        int left = 1;int right = Integer.MAX_VALUE;int mid = 0;
        // 取中间值，无符号右移1，等同于除以二
        while (left<=right) {
            mid = left+((right-left)>>1);
            // 如果b*mid>=a，则符合条件，继续寻找符合条件的临界值。
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
//     * 构造一个工具，验证mid*b>=a
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

    // 快速乘
    public static boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            // z==1
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            // z = z>>1,z除以二
            z >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(divide1(15,2));
    }
}
