package com.company;

import com.company.Sort.Common;
import com.company.Sort.QuickSort.QuickSortLearn2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List list = new Common().constructor(100, 10);
//        List list = new ArrayList();
//        list.add(83);
//        list.add(73);
//        list.add(73);
//        list.add(71);
//        list.add(68);
//        list.add(35);
//        list.add(12);
//        list.add(80);
//        list.add(66);
//        list.add(66);
//       ����˵��ȡһ���֣�����С�ķ���ߣ���ķ��ұߣ������ӵݹ�
//        1.���ȡһ����׼�㣬��������������ҵ㣬�������ֱ�����ڻ�׼��ֹͣ���ҵ�����ֱ��С���׼��ֹͣ
//        2.���߽�������������
//        3.����ֹͣ�Ҵ���ͬһλ��ʱ������׼�������м䣬һ���������
//?       4.������ֵ��Ϊ�������ݹ���ú�������
        int c = 0;
        new QuickSortLearn2().Q_Sort(list, 0, list.size() - 1, c);
        System.out.println("��ѭ����" + c + "��");

    }
}
