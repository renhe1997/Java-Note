package com.company.LeetCode.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * ���룺"23"
 * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * @Author: RenHe
 * @Date: 2021/5/14 11:40
 */
public class TelGroup {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List resultList = getGroup("2341","",0, list);
        System.out.println(resultList.toString());
    }
    public static List getGroup(String targetNums,String pattern,int index,List resultList) {
        String[] initNums = {
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz", // 9
        };
        // ֹͣ���� ���Ѿ�������Ҷ�ӽڵ㣬�洢��Ͻ�������ء�
        if (index==targetNums.length()){
            resultList.add(pattern);
            return resultList;
        }
        int num = targetNums.charAt(index)-48;
        // �ų�01�����
        if(num==1||num==0){
            resultList.add(pattern);
            return resultList;
        }
        // ��һ���֧������numsȡ��Ӧ��String
        String str =  initNums[num];
        // ѭ������ �Ե�һ���֧����ѭ����
        for (int i = 0; i < str.length(); i++) {
            getGroup(targetNums,pattern+str.charAt(i),index+1,resultList);
        }
        return resultList;
    }
}
















