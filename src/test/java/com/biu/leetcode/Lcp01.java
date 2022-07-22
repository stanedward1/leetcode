package com.biu.leetcode;

/**
 * @Class_name Lcp01
 * @Description https://leetcode.cn/problems/guess-numbers/
 * @Author longbiu
 * @Date 2022/7/20 15:21
 **/
public class Lcp01 {
    public int game(int[] guess, int[] answer) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                sum += 1;
            }
        }
        return sum;
    }
}
