package com.company.LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 349��. ��������Ľ���
 * ����[12352] [24] ��� [2]
 * ˼·�� ���ȥ�أ������򣬱Ƚ��Ƿ��У���set
 * @Author: RenHe
 * @Date: 2021/5/11 17:04
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        int[] f = {1,4,2};
        int[] s = {2,4,3};
        Set resultSet  = getIntersection(f,s);
        System.out.println(resultSet.toString());
    }
    public static Set getIntersection(int[] f, int[] s){
        Set set = new HashSet();
        Set resultSet  = new HashSet();
        for(int i = 0;i<f.length;i++){
            set.add(f[i]);
        }
        for(int i = 0;i<s.length;i++){
            if(set.contains(s[i])){
                resultSet.add(s[i]);
            }
        }
        return resultSet;
    }
}
