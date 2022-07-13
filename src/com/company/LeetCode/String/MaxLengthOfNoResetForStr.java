package com.company.LeetCode.String;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class MaxLengthOfNoResetForStr {
    public static int maxLengthOfNoResetForStr(String str){
        int length = 0;
        int first = 0;int second = 1;
        Set set = new HashSet();
        set.add(str.charAt(first));
        while (second<str.length()&&first<=second){
            // 如果为正，则说明不存在
            char s = str.charAt(second);
            if(set.add(s)){
                length = Math.max(length,second-first+1);
                second++;
            }else {
                set.remove(str.charAt(first));
                first++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "asdfsdddsa";
        Set set = new HashSet();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(set.add(str.charAt(i)));
        }
        System.out.println(maxLengthOfNoResetForStr(str));
    }
}
