package com.company.LeetCode.Other;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
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
        // 停止条件 树已经遍历到叶子节点，存储组合结果并返回。
        if (index==targetNums.length()){
            resultList.add(pattern);
            return resultList;
        }
        int num = targetNums.charAt(index)-48;
        // 排除01的情况
        if(num==1||num==0){
            resultList.add(pattern);
            return resultList;
        }
        // 第一层分支，根据nums取对应的String
        String str =  initNums[num];
        // 循环操作 对第一层分支进行循环，
        for (int i = 0; i < str.length(); i++) {
            getGroup(targetNums,pattern+str.charAt(i),index+1,resultList);
        }
        return resultList;
    }
}
















