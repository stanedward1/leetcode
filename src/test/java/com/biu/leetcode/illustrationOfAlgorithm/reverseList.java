package com.biu.leetcode.illustrationOfAlgorithm;

import com.biu.leetcode.ListNode;

/**
 * @Class_name reverseList
 * @Description https://leetcode.cn/leetbook/read/illustration-of-algorithm/9pdjbm/
 * @Author longbiu
 * @Date 2022/7/18 17:32
 **/
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
