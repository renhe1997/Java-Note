package com.company.LeetCode.Other;

import java.util.HashMap;

/**
 * 最近最少使用-淘汰策略
 * @Author: RenHe
 * @Date: 2020/12/28 19:16
 */
public class LRU extends HashMap {
    //实时大小
    private int count;
    //预定大小
    private int capacity;
    //HashMap
    private HashMap hashMap;
    //头结点尾节点
    private Node head,tail;
    //链表（双向）
    class Node {
        private Object key;
        private Object value;
        private Node head;
        private Node tail ;
        //根据hashMap的Key取链表节点
        public Node getNode(Object key){
            Node node = (Node) hashMap.get(key);
            return node;
        }
        //插入链表节点（头插）
        public void addNode(Node node){
            //插入节点的尾部=原有节点
            node.tail=head;
             //原节点的头部=插入节点
             head.head=node;
             //插入节点=头结点
             head=node;
        }
        //删除指定节点
        public void removeNode(Node node){
            //如果是尾节点
            if (node==tail){
                tail.head.tail=null;
            }
            //如果不是尾节点
            else {
                //头结点的尾节点=尾节点
                node.head.tail=node.tail;
                //尾节点的头结点=头结点
                node.tail.head=node.head;
            }
        }
    }
    //访问
    public Object getLur(Object key){
        Node e = new Node().getNode(key);
        if (e!=null){
            //放到链表头部
            this.putToHead(e);
        }
        return e;
    }
    //添加
    public void setLur(Object key,Object value){
        //如果不存在，则新增，存在则修改
        Node node = (Node) hashMap.get(key);
         if (node==null){
             Node e = new Node();
             e.key = key;
             e.value = value;
             //链表添加节点
             node.addNode(e);
             //hashMap添加key，value值为节点值
             hashMap.put(key,e);
             ++count;
             //删除
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

    //将节点放值链表头结点,先删后插
    public void putToHead(Node node){
        node.removeNode(node);
        node.addNode(node);

    }
}
