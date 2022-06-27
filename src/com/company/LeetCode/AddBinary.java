package com.company.LeetCode;

public class AddBinary {
    /**
     * 二进制加法
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     * 输入: a = "11", b = "10"
     * 输出: "101"
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     *
     * 注意：本题与主站 67?题相同：https://leetcode-cn.com/problems/add-binary/
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a,String b){
        String result = "";
        if (a.length()<1||b.length()>Math.pow(10,4)){
            return "0";
        }
        // 模拟加法
        int first = a.length();int second = b.length();int mid = 0;
        int n = Math.max(first,second);
        for (int i = 0; i < n; ++i) {
           mid = mid+ (i<a.length()?(a.charAt(first-1-i)-'0'):0);
           mid = mid+ (i<b.length()?(b.charAt(second-1-i)-'0'):0);
           result = result+(char)(mid%2+'0');
           mid = mid/2;
        }
        if (mid>0){
            result = result+'1';
        }
        return new StringBuffer(result).reverse().toString();
    }

    /**
     * 把 aa 和 bb 转换成整型数字 xx 和 yy，在接下来的过程中，xx 保存结果，yy 保存进位。
     * 当进位不为 00 时
     * 计算当前 xx 和 yy 的无进位相加结果：answer = x ^ y
     * 计算当前 xx 和 yy 的进位：carry = (x & y) << 1
     * 完成本次循环，更新 x = answer，y = carry
     * 返回 xx 的二进制形式
     * 为什么这个方法是可行的呢？在第一轮计算中，answer 的最后一位是 xx 和 yy 相加之后的结果，
     * carry 的倒数第二位是 xx 和 yy 最后一位相加的进位。
     * 接着每一轮中，由于 carry 是由 xx 和 yy 按位与并且左移得到的，
     * 那么最后会补零，所以在下面计算的过程中后面的数位不受影响，
     * 而每一轮都可以得到一个低 ii 位的答案和它向低 i + 1i+1 位的进位，也就模拟了加法的过程。
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a,String b){
        // 异或的符号是^。按位异或运算, 对等长二进制模式按位或二进制数的每一位执行逻辑按位异或操作. 操作的结果是如果某位不同则该位为1, 否则该位为0.
        // 异或运算的逆运算是它本身，也就是说两次异或同一个数最后结果不变，即（a ^ b) ^ b = a
        // todo 这里留存一个疑虑，字符串“111”传入之后，被认为是十进制的111Int型整数进行运算，那么应该如何将111字符串转化为111二进制进行运算呢？
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        while (y!=0){
            int temp = x^y;
            y = (x&y)<<1;
            x = temp;
        }
        return Integer.toBinaryString(x);
    }

    public static void main(String[] args) {
        System.out.println(addBinary1("11","10"));
        System.out.println(11&10);
        System.out.println((11&10) << 1);
        System.out.println(Integer.toBinaryString(1111));
    }
}
