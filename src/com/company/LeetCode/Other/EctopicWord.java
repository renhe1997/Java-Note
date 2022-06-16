package com.company.LeetCode.Other;

/**
 * 242题. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 例： s= "aee", t = "eae" true；
 * 思路：1.双重for循环
 *      2.用一个数组记录单个字符串中每个字母出现的次数，遍历第一个时+，遍历第二个字符串时-，判断最后是否为零
 * @Author: RenHe
 * @Date: 2021/5/11 10:55
 */
public class EctopicWord {
    public static boolean isEctopic(String s, String t){
        char[] charS = s.toCharArray();
        char[] chart = t.toCharArray();
        int[] charNum = new int[26];
        for(int i = 0;i<charS.length;i++){
            charNum[charS[i]-'a']++;
        }
        for(int i = 0;i<chart.length;i++){
            charNum[chart[i]-'a']--;
        }
        for(int i = 0;i<charNum.length;i++){
            if(charNum[i]!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        boolean isEctopic = isEctopic("aee","eea");
        System.out.println(isEctopic);
    }
}





























