package com.biu.leetcode;

/**
 * @Class_name T5
 * @Description ……
 * @Author longbiu
 * @Date 2022/6/21 15:02
 **/
public class T5 {
    public String longestPalindrome(String s) {
        // 边界条件判断
        int len = s.length();
        if (len < 2) {
            return s;
        }
        // start: 回文串开始的下标
        // maxLen：最长回文串的长度
        int start = 0, maxLen = 0;
        for (int i = 0; i < len; ) {
            if (len - 1 <= maxLen / 2)
                break;
            int left = i, right = i;

            // 过滤重复字符
            while (right < len - 1 && s.charAt(right + 1) == s.charAt(right))
                ++right;
            // 下次判断从重复元素的下标开始
            i = right + 1;
            while (right < len - 1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                ++right;
                --left;
            }
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
