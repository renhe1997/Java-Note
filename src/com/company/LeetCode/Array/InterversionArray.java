package com.company.LeetCode.Array;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.*;

/**
 * 排序数组相交
 * @Author: RenHe
 * @Date: 2021/10/15 17:02
 */
public class InterversionArray {
    public static int[] getInversion(int[] array1,int[] array2){
        int arr1L = array1.length;
        int arr2L = array2.length;
        if (arr1L==0||arr2L==0){
            return null;
        }
        // 前后值不连接
        if (array1[0]>array2[arr2L-1]||array1[arr1L-1]<array2[0]){
            return null;
        }
        List<Integer> resultArr = new ArrayList();
        while(arr1L!=0&&arr2L!=0){
            if(array1[array1.length-arr1L]>array2[array2.length-arr2L]){
                arr2L--;
            }else if(array1[array1.length-arr1L]<array2[array2.length-arr2L]){
                arr1L--;
            }else{
                resultArr.add(array1[array1.length-arr1L]);
                arr1L--;arr2L--;
            }
        }
        return resultArr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static char find(char[] charsA,char[] charsB){
        char r = '0';
        Stack stackA = new StringStack();
        Stack stackB = new StringStack();
        for (char a : charsA){
            stackA.push(a);
        }
        for (char b : charsB){
            stackB.push(b);
        }
        while (stackA!=null&&stackB!=null){
            if (stackA.peek()==stackB.peek()){
                stackA.pop();
                stackB.pop();
            }else{
                if(stackA.size()>stackB.size()){
                    r = (char) stackA.pop();
                }else{
                    r = (char) stackB.pop();
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arrA = {1,4,6,9};
        int[] arrB = {1,2,4,7,9};
        System.out.println(Arrays.toString(getInversion(arrA,arrB)));
    }




















}
