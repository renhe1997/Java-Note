package com.company.LeetCode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class CheckInclusion {
    /**
     * V2滑动窗口解法
     * 字符串变数组标记出现次数，滑动窗口长度为短字符串，滑过去
     * @param s1
     * @param s2
     * @return
     */
    public static boolean getCheckInclusion(String s1,String s2){
        boolean isInclusion = false;
        int first = 0; int second = s1.length()-1;
        char[] c2 = s2.toCharArray();
        char[] c1 = s1.toCharArray();
        if (c1.length>c2.length){
            return false;
        }
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i)-'a']++;
            a2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(a1,a2)){
            return true;
        }
        while (second<c2.length&&first<=second){
            if(Arrays.equals(a1,a2)){
                isInclusion = true;
                break;
            }
            a2[s2.charAt(first)-'a']--;
            first++;
            second++;
            if (second<c2.length) {
                a2[s2.charAt(second) - 'a']++;
            }

        }
        return isInclusion;
    }

    /**
     * V1 暴力解法
     * 列举出所有子串，Map记录出现次数。
     * @param s1
     * @param s2
     * @return
     */
    public static boolean getCheckInclusion1(String s1,String s2){
        int first = 0; int second = s1.length()-1;
        if (s1.length()>s2.length()){
            return false;
        }
        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            if(isEquals(s1,s2.substring(first,second+1))){
                return true;
            }
            first++;second++;
        }
        return false;
    }

    private static boolean isEquals(String s1, String s2) {
        Map map = new HashMap();
        for(char c :s1.toCharArray()){
            int num = (int)map.getOrDefault(c,0);
            map.put(c,num+1);
        }
        for(char c :s2.toCharArray()){
            int num = (int)map.getOrDefault(c,0);
            map.put(c,num-1);
        }
        Iterator iterator = map.values().iterator();
        while (iterator.hasNext()){
            if ((int)iterator.next()!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // "adc"
        //"dcda"
        System.out.println(getCheckInclusion1("adc","dcda"));
    }
}