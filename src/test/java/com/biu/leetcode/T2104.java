package com.biu.leetcode;

/**
 * @ClassName T2104
 * @Description 子数组范围和
 * @Author biu
 * @Date 2022/3/4 12:21 PM
 **/
public class T2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }
}
