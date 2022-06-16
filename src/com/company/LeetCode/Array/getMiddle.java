package com.company.LeetCode.Array;

/**
 * 求两数组的中位数
 * @Author: RenHe
 * @Date: 2021/10/20 18:55
 */
public class getMiddle {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0;
        int m = nums1.length;
        int n = nums2.length;
        int sumLength = m+n;
        // 放到一起，排序，求中位
        int[] sumArr = new int[sumLength];
        // 双指针判断
        int i=0,j=0;
        // 新数组指针
        int k=0;
        while(i < m && j < n){
            if(nums1[i]<nums2[j]){
                sumArr[k++] = nums1[i++];
            }else{
                sumArr[k++] = nums2[j++];
            }
        }
        // 数组1循环完了而数组2未完
        while(i == m && j < n){
            sumArr[k++] = nums2[j++];
        }
        // 数组2循环完了而数组1未完
        while(i < m && j == n){
            sumArr[k++] = nums1[i++];
        }
        // 求中位
        if(sumLength%2==0){
            middle = ((double)(sumArr[sumLength/2]+sumArr[sumLength/2-1]))/2;

        }else{
            middle = sumArr[sumLength/2];

        }
        return middle;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7};
        int[] arr2 = {2,4,6,8};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }

}
