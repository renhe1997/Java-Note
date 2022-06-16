package com.company.LeetCode.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: RenHe
 * @Date: 2021/11/13 11:39
 */
public class SubList {
    public static void main(String[] args) {
        List<List> custSumList = new ArrayList<List>();
        List custForSendList = new ArrayList();
        for (int i = 0; i < 42; i++) {
            custForSendList.add("1");
        }
        int j = custForSendList.size() / 10;
        for (int i = 1; i < j+1; i++) {
            custSumList.add(custForSendList.subList((i-1) * 10, i*10));
            System.out.println("custSumList.size()"+custSumList.size());
        }

        custSumList.add(custForSendList.subList(j*10, custForSendList.size()));
        System.out.println("custSumList.size()"+custSumList.size());
        System.out.println("custSumList.size()"+custSumList.get(3).size());
        System.out.println(custSumList.toString());
    }
}
