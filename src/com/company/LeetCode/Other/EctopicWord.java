package com.company.LeetCode.Other;

/**
 * 242��. ��Ч����ĸ��λ��
 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�
 * ���� s= "aee", t = "eae" true��
 * ˼·��1.˫��forѭ��
 *      2.��һ�������¼�����ַ�����ÿ����ĸ���ֵĴ�����������һ��ʱ+�������ڶ����ַ���ʱ-���ж�����Ƿ�Ϊ��
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





























