package com.company.LeetCode.Other;

import java.util.HashMap;

/**
 * �������ʹ��-��̭����
 * @Author: RenHe
 * @Date: 2020/12/28 19:16
 */
public class LRU extends HashMap {
    //ʵʱ��С
    private int count;
    //Ԥ����С
    private int capacity;
    //HashMap
    private HashMap hashMap;
    //ͷ���β�ڵ�
    private Node head,tail;
    //����˫��
    class Node {
        private Object key;
        private Object value;
        private Node head;
        private Node tail ;
        //����hashMap��Keyȡ����ڵ�
        public Node getNode(Object key){
            Node node = (Node) hashMap.get(key);
            return node;
        }
        //��������ڵ㣨ͷ�壩
        public void addNode(Node node){
            //����ڵ��β��=ԭ�нڵ�
            node.tail=head;
             //ԭ�ڵ��ͷ��=����ڵ�
             head.head=node;
             //����ڵ�=ͷ���
             head=node;
        }
        //ɾ��ָ���ڵ�
        public void removeNode(Node node){
            //�����β�ڵ�
            if (node==tail){
                tail.head.tail=null;
            }
            //�������β�ڵ�
            else {
                //ͷ����β�ڵ�=β�ڵ�
                node.head.tail=node.tail;
                //β�ڵ��ͷ���=ͷ���
                node.tail.head=node.head;
            }
        }
    }
    //����
    public Object getLur(Object key){
        Node e = new Node().getNode(key);
        if (e!=null){
            //�ŵ�����ͷ��
            this.putToHead(e);
        }
        return e;
    }
    //���
    public void setLur(Object key,Object value){
        //��������ڣ����������������޸�
        Node node = (Node) hashMap.get(key);
         if (node==null){
             Node e = new Node();
             e.key = key;
             e.value = value;
             //������ӽڵ�
             node.addNode(e);
             //hashMap���key��valueֵΪ�ڵ�ֵ
             hashMap.put(key,e);
             ++count;
             //ɾ��
             if (++count>capacity){
                 hashMap.remove(tail.key);
                 node.removeNode(tail);
                 --count;
             }
         }else{
             node.value=value;
             putToHead(node);
         }
    }

    //���ڵ��ֵ����ͷ���,��ɾ���
    public void putToHead(Node node){
        node.removeNode(node);
        node.addNode(node);

    }
}
