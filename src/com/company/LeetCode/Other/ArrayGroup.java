package com.company.LeetCode.Other;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * ��77��. ���
 * ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�
 *
 * ʾ��:
 * ����: n = 4, k = 2
 * ���: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]
 * @Author: RenHe
 * @Date: 2021/5/17 14:51
 */
public class ArrayGroup {
    static List<List> resultList = new ArrayList();
    static List temp = new ArrayList();
    public static void main(String[] args) {
        int n = 4,k = 2;
        List nums = new ArrayList();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
       // getGroup(nums,2,0);
//        backTrace(temp,4,2,0);
        getGroup2(nums);
        System.out.println(resultList.toString());
    }
    public static void getGroup(List numsList,int k,int index){
        if (!temp.isEmpty()&&k==temp.size()){
            resultList.add(new ArrayList(temp));// ����Ҫ��new�������޸Ļ�ָ��ͬһ����ַ
            return;
        }
        for (int i = index; i < numsList.size(); i++) {
            temp.add(numsList.get(i)); // 1 2
            getGroup(numsList,k,index+1);
            temp.remove(temp.size()-1);
            index++;
        }
    }
    private static void backTrace(List<Integer>list, int n, int k, int depth) {
        if (depth > k) {
            return;
        }
        if (depth == k) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
            backTrace(list, n, k, depth + 1);
            list.remove(list.size() - 1);
        }
    }

    /**
     * ȡ���������
     * @param list
     */
    public static void getGroup2(List list){
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
            for (int j = i+1; j < list.size(); j++) {
                if (temp.size()==2){
                    temp.remove(1);
                }
                temp.add(list.get(j));
                resultList.add(new ArrayList(temp));
            }
            temp.clear();
        }
    }



























    }
