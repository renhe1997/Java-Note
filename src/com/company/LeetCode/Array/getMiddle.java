package com.company.LeetCode.Array;

/**
 * �����������λ��
 * @Author: RenHe
 * @Date: 2021/10/20 18:55
 */
public class getMiddle {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0;
        int m = nums1.length;
        int n = nums2.length;
        int sumLength = m+n;
        // �ŵ�һ����������λ
        int[] sumArr = new int[sumLength];
        // ˫ָ���ж�
        int i=0,j=0;
        // ������ָ��
        int k=0;
        while(i < m && j < n){
            if(nums1[i]<nums2[j]){
                sumArr[k++] = nums1[i++];
            }else{
                sumArr[k++] = nums2[j++];
            }
        }
        // ����1ѭ�����˶�����2δ��
        while(i == m && j < n){
            sumArr[k++] = nums2[j++];
        }
        // ����2ѭ�����˶�����1δ��
        while(i < m && j == n){
            sumArr[k++] = nums1[i++];
        }
        // ����λ
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
