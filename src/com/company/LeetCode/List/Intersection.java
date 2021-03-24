package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * �����ཻ
 * @Author: RenHe
 * @Date: 2021/3/18 20:25
 */
public class Intersection {
    /**
     * ���ཻ��������ĵ�һ������
     * ����һ�� ����a-b��ͬʱ����ƶ�ָ�룬�Ա���ͬ��
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static int getIntersection(NodeData nodeA, NodeData nodeB){
        NodeData A = nodeA;
        NodeData B = nodeB;
        // ���ڵ�������λ����ͬ�ڵ���
        int step = A.length(A)-B.length(B);
        if (A.length(A)-B.length(B)>0){
            while(step==0){
                step--;
                nodeA=nodeA.getNextNode();
            }
        }else{
            while(step==0){
                step++;
                nodeB=nodeB.getNextNode();
            }
        }
        // ��ʱ��A��B����ָ���ʣ��ڵ�����ͬ��ѭ���Ա�
        while (null!=nodeA){
            if (nodeA.getData()==nodeB.getData()){
                break;
            }else{
                nodeA=nodeA.getNextNode();
                nodeB=nodeB.getNextNode();
            }
        }
        return nodeA.getData();
    }

    /**
     * ��������ĵ�һ������
     * �������� a+(b-c)=b+(a-c)
     * @param nodeA
     * @param nodeB
     * @return
     */
    public static int getIntersection2(NodeData nodeA, NodeData nodeB){
        // �п�
        if (null==nodeA||null==nodeB){
            return 0;
        }
        NodeData A = nodeA;
        NodeData B = nodeB;
        // ѭ�� a+(b-c)=b+(a-c)
        while (A.getData()!=B.getData()){
            A=A.getNextNode()==null?nodeB:A.getNextNode();
            B=B.getNextNode()==null?nodeA:B.getNextNode();
        }
        return A.getData();
    }

    /**
     * �ж������ǲ��Ǵ���
     * A��һ��B������������A=B�������
     * @param nodeA
     * @return
     */
    public static Boolean isLoop(NodeData nodeA){
        // �п�
        Boolean isLoop = false;
        if (null==nodeA){
            return false;
        }
        NodeData A = nodeA.getNextNode();
        NodeData B = nodeA.getNextNode().getNextNode();
        while (A!=null&&B!=null){
            if(A==B){
                isLoop = true;
                break;
            }
            A = nodeA.getNextNode();
            B = B.getNextNode().getNextNode();
        }
        return isLoop;
    }




















    public static void main(String[] args) {
        NodeData A = new NodeData(2);
        NodeData A2 = new NodeData(1);
        NodeData A3 = new NodeData(4);
        A.setNextNode(A2);
        A2.setNextNode(A3);
        A3.setNextNode(new NodeData(3));
        System.out.println(A.toStingData(A));
        NodeData B = new NodeData(1);
        NodeData B2 = new NodeData(9);
        NodeData B3 = new NodeData(4);
        B.setNextNode(B2);
        B2.setNextNode(B3);
//        B3.setNextNode(B);// ��β������ѭ��
        System.out.println(B.toStingData(B));
        System.out.println("��������Ϊ���������"+isLoop(B));
        System.out.println("�ཻ�ڵ�����Ϊ��"+getIntersection2(A,B));

    }





















}
