package com.biu.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Class_name T532
 * @Description 数组中的 k-diff 数对
 * @Author longbiu
 * @Date 2022/6/16 14:43
 **/
public class T532 {
    public int findPairs(int[] nums, int k) {
        // 把当前元素左边的value放进HashSet
        Set<Integer> visited = new HashSet<Integer>();
        // 把符合条件的元素放进来，去重一下，放了几次就代表有几个k-diff数对
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            // 判断键值对条件
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }
}
