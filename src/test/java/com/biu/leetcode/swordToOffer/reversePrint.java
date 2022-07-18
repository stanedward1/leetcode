package com.biu.leetcode.swordToOffer;

import com.biu.leetcode.ListNode;

/**
 * @Class_name reversePrint
 * @Description ……
 * @Author longbiu
 * @Date 2022/7/18 16:11
 **/
public class reversePrint {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while(node != null){
            size++;
            node = node.next;
        }
        int[] intVals = new int[size];
        node = head;
        while(node != null){
            intVals[--size] = node.val;
            node = node.next;
        }
        return intVals;
    }
}
