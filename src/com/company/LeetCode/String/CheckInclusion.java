package com.company.LeetCode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ��ָ Offer II 014. �ַ����еı�λ��
 * ���������ַ��� s1 �� s2��дһ���������ж� s2 �Ƿ���� s1 ��ĳ����λ�ʡ�
 *
 * ���仰˵����һ���ַ���������֮һ�ǵڶ����ַ����� �Ӵ� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ����: s1 = "ab" s2 = "eidbaooo"
 * ���: True
 * ����: s2 ���� s1 ������֮һ ("ba").
 * ʾ�� 2��
 *
 * ����: s1= "ab" s2 = "eidboaoo"
 * ���: False
 *
 *
 * ��ʾ��
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 �� s2 ������Сд��ĸ
 */
public class CheckInclusion {
    /**
     * V2�������ڽⷨ
     * �ַ����������ǳ��ִ������������ڳ���Ϊ���ַ���������ȥ
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
     * V1 �����ⷨ
     * �оٳ������Ӵ���Map��¼���ִ�����
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