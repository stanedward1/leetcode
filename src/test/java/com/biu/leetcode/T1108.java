package com.biu.leetcode;

/**
 * @Class_name T1108
 * @Description [1108. IP 地址无效化](https://leetcode.cn/problems/defanging-an-ip-address/)
 * @Author longbiu
 * @Date 2022/6/21 09:44
 **/
public class T1108 {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (Character c : address.toCharArray()) {
            if (c == '.') res.append("[.]");
            else res.append(c);
        }
        return res.toString();
    }
}
