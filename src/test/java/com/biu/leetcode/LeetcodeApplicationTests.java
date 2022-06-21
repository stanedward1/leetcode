package com.biu.leetcode;

import com.biu.leetcode.zuochengyun.MyStack1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void T2() {
        T2 solution = new T2();
        ListNode l1 = new ListNode(2);
        l1.add(4);
        l1.add(3);
        ListNode l2 = new ListNode(5);
        l2.add(6);
        l2.add(4);
        System.out.println("第一个链表是：");
        l1.print();
        System.out.println("\n");
        System.out.println("第二个链表是：");
        l2.print();
        System.out.println("\n");
        System.out.println("两数相加为：");
        solution.addTwoNumbers(l1, l2);
    }

    @Test
    void T3(){
        T3 solution = new T3();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void T5(){
        T5 solution = new T5();
        System.out.println(solution.longestPalindrome("aaaaaaaaa"));
    }

    @Test
    void T532() {
        T532 solution = new T532();
        int result = solution.findPairs(new int[]{3, 1, 4, 1, 5}, 2);
        System.out.println(result);
    }

    @Test
    void T1089() {
        T1089 solution = new T1089();
        int[] arr = {1, 9, 2, 3, 4, 5};
        solution.duplicateZeros(arr);
    }

    @Test
    void T2104() {
        T2104 solution = new T2104();
        long result = solution.subArrayRanges(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

    @Test
    void T1108() {
        T1108 solution = new T1108();
        String address = "1.1.1.1";
        String result = solution.defangIPaddr(address);
        System.out.println(result);
    }

    @Test
    void MyStack1() {
        MyStack1 mystal = new MyStack1();
        int[] arr = {3, 4, 5, 1, 2, 1, 9};
        for (int item : arr) {
            mystal.push(item);
            System.out.println("压入数据为" + item);
        }
        System.out.println("返回栈中最小元素为：" + mystal.getmin());
    }
}
