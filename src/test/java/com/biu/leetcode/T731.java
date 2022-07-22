package com.biu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class_name T731
 * @Description https://leetcode.cn/problems/my-calendar-ii/
 * @Author longbiu
 * @Date 2022/7/19 15:15
 **/
public class T731 {
    List<int[]> booked;
    List<int[]> overlaps;

    public T731() {
        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        for (int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                return false;
            }
        }
        for (int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if (l < end && start < r) {
                overlaps.add(new int[]{Math.max(l, start), Math.min(r, end)});
            }
        }
        booked.add(new int[]{start, end});
        return true;
    }
}
