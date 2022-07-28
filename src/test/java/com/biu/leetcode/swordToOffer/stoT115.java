package com.biu.leetcode.swordToOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Class_name T115
 * @Description https://leetcode.cn/problems/ur2n8P/
 * @Author longbiu
 * @Date 2022/7/23 23:35
 **/
public class stoT115 {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        Map<Integer, Set<Integer>> d = new HashMap<>();
        for (int[] x : sequences) {
            for (int i = 1; i < x.length; i++) {
                d.putIfAbsent(x[i - 1], new HashSet<Integer>());
                d.get(x[i - 1]).add(x[i]);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (!d.getOrDefault(nums[i - 1], new HashSet<Integer>()).contains(nums[i])) return false;
        }
        return true;
    }
}
