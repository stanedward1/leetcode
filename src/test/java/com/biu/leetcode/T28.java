package com.biu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class_name T28
 * @Description https://leetcode.cn/problems/implement-strstr/
 * @Author longbiu
 * @Date 2022/7/20 14:27
 **/
public class T28 {
    public int strStr(String haystack, String needle) {
        int size = needle.length();
        for (int i = 0;  i<haystack.length(); i++){
           if(haystack.substring(i,haystack.length()).startsWith(needle)){
               return i;
           }
        }
        return -1;
    }
}
