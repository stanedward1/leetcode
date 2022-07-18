package com.biu.leetcode.zuoChengYun;

import java.util.Stack;

/**
 * @Class_name TwoStacksQueue
 * @Description 由两个栈组成的队列，支持队列的基本操作（add,poll(检索并删除队列头部),peek（检索但不删除队列头部））
 * @Author longbiu
 * @Date 2022/6/20 15:10
 **/
public class TwoStacksQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
