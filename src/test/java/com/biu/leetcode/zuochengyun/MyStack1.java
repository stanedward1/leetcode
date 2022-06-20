package com.biu.leetcode.zuochengyun;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Class_name MyStack1
 * @Description 设计一个有getmin功能的栈
 * @Author longbiu
 * @Date 2022/6/20 12:10
 **/
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    /**
     * 先将newNum压入stackData，然后判断stackMin是否为空
     * 1.如果为空，则将newNum压入stackMin
     * 2.如果不为空，而且newNum更小，或者两者相等，newNum压入stackMin
     *
     * @param newNum
     */
    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getmin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    /**
     * 取最小数值对象
     *
     * @return arr's min value
     */
    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty!!!");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()) {
            this.stackMin.pop();
        }
        return value;
    }

    /**
     * 用来取stackMin的栈顶对象
     *
     * @return this.stackMin.peek()
     */
    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!!!");
        }
        return this.stackMin.peek();
    }
}
