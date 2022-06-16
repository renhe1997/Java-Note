package com.company.LeetCode.List;

import com.company.LeetCode.BaseData.NodeData;

/**
 * 19.ɾ������ĵ�����N���ڵ�
 * @Author: RenHe
 * @Date: 2021/5/31 15:32
 */
public class RemoveNthFromEnd {
    static class Nodes{
        private Nodes nextNode;
        private int data;
        public int getData() {
            return data;
        }
        public Nodes getNextNode() {
            return nextNode;
        }
        public void setData(int data) {
            this.data = data;
        }
        public void setNextNode(Nodes nextNode) {
            this.nextNode = nextNode;
        }
        public Nodes(){};
        public Nodes(int data,Nodes nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }


    }
    static Nodes head = new Nodes();
    static Nodes current = new Nodes();
    static void add(int data){
        if (null==head.getNextNode()){
            head.setData(data);
            head.setNextNode(new Nodes());
            current = head;
        }else{
            current.setNextNode(new Nodes(data,null));
            current = current.getNextNode();
        }
    }
    public static String toStingData(Nodes node){
        StringBuffer sb = new StringBuffer();
        while (null != node){
            sb.append(node.getData()).append(",");
            node = node.getNextNode();
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            add(i);
        }
        System.out.println(toStingData(removeNthFromEnd(3)));
    }

    /**
     * �������Ĺؼ����ڣ���ô�ҵ�������N���ڵ�
     * ��˫ָ�룬�������N������ʱ����ָ�����N�����룬֮�����һ��һ�����ߣ�ֱ����ĵ����յ�
     * ��ʱ�����ľ����յ�ΪN
     * @param n
     * @return
     */
    public static Nodes removeNthFromEnd(int n){
        Nodes dummyNode = new Nodes(-1,head);
        Nodes fastNode = dummyNode;
        Nodes slowNode = dummyNode;
        for (int i = 0; i < n+1; i++) {
            fastNode = fastNode.getNextNode();
        }
        Nodes priNode = null;
        while (fastNode.getNextNode()!=null){
            priNode = slowNode;
            fastNode = fastNode.getNextNode();
            slowNode = slowNode.getNextNode();
        }
        priNode.setNextNode(slowNode.getNextNode());
        return dummyNode.getNextNode();
    }








    public static Nodes removeNthFromEnd2(int n){
        Nodes dummyNode = new Nodes(-1,head);
        Nodes fastNode  = dummyNode;
        Nodes slowNode  = dummyNode;

        for (int i = 0; i < n+1; i++) {
            if (null != fastNode.getNextNode()) {
                fastNode = fastNode.getNextNode();
            }else{
                System.out.println("��������ȷ��n");
                break;
            }
        }
        Nodes priNode = null;
        while (null!=fastNode){
            priNode = slowNode;
            fastNode = fastNode.getNextNode();
            slowNode = slowNode.getNextNode();
        }
        priNode.setNextNode(slowNode.getNextNode());
        return dummyNode.getNextNode();
    }



}























