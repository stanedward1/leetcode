package com.biu.leetcode.illustrationOfAlgorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Class_name isNumber
 * @Description https://leetcode.cn/leetbook/read/illustration-of-algorithm/5d6vi6/
 * @Author longbiu
 * @Date 2022/7/18 17:15
 **/
public class isNumber {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                new HashMap<>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                new HashMap<>() {{
                    put('d', 3);
                }},
                new HashMap<>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                new HashMap<>() {{
                    put('d', 7);
                }},
                new HashMap<>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                new HashMap<>() {{
                    put(' ', 8);
                }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';
            if (!states[p].containsKey(t)) return false;
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
