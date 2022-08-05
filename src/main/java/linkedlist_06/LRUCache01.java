package linkedlist_06;

import java.util.HashMap;

//请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
//实现 LRUCache 类：
//LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
//函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
//
//链接：https://leetcode.cn/problems/lru-cache
public class LRUCache01 {
    private static class DlinkedNode {
        private DlinkedNode prev;
        private DlinkedNode next;
        private int key;
        private int val;

        DlinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    private int capacity;
    private HashMap<Integer, DlinkedNode> cache = new HashMap<>();
    private DlinkedNode dummyHead ;
    private DlinkedNode dummyTail ;

    LRUCache01(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.dummyHead = new DlinkedNode(-1, -1);
        this.dummyTail = new DlinkedNode(-1, -1);
        //dummyHead与dummyTail要互相拼接起来
        this.dummyHead.prev = null;
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
        this.dummyTail.next = null;
    }

    //查询hashmap中的key是否存在，如果存在，那么返回并且更新缓存；否则，返回-1
    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);//删除当前节点
        addNodeToHead(node);//将节点放到链首
        return node.val;
    }

    private void addNodeToHead(DlinkedNode node) {
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        node.prev = dummyHead;
    }

    private void removeNode(DlinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void remove(int key) {
        DlinkedNode node = cache.get(key);
        if (node != null) {
            cache.remove(node.key);
            removeNode(node);
            size--;
        }
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node != null) {//元素已经存在，需要先更新节点值，再放到队首
            node.val = value;
            removeNode(node);
            addNodeToHead(node);
            return;
        }

        //先判断缓存是否已经满
        if (size == capacity) {
            //移除最久未被查询元素的key和value
            cache.remove(dummyTail.prev.key);
            removeNode(dummyTail.prev);
            size--;
        }

        //创建元素节点
        DlinkedNode newNode = new DlinkedNode(key, value);
        cache.put(key, newNode);
        addNodeToHead(newNode);
        size++;
    }

    //尽量避免使用过多的if···else逻辑，过多的if···else逻辑会让代码更难阅读

}
