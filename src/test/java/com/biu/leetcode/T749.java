package com.biu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class_name T749
 * @Description https://leetcode.cn/problems/contain-virus/comments/
 * @Author longbiu
 * @Date 2022/7/18 21:27
 **/
public class T749 {
    int[][] grid;
    int m, n;
    int willCount = 0;
    int wallCount = 0;
    int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int res = 0;

    public int containVirus(int[][] isInfected) {
        grid = isInfected;
        m = isInfected.length;
        n = isInfected[0].length;
        List<Region> regions = find();
        while (regions.size() > 0) {
            int idx = 0;
            int maxWillCount = 0;
            for (int i = 0; i < regions.size(); i++) {
                int c = regions.get(i).willInfectedCount;
                if (c > maxWillCount) {
                    idx = i;
                    maxWillCount = c;
                }
            }
            for (int i = 0; i < regions.size(); i++) {
                Region region = regions.get(i);
                if (idx == i) updateBlockadedDfs(region.infected, region.i, region.j);
                else updateBlockadedDfs(region.infected, region.i, region.j);
                System.out.println();
            }
            res += regions.get(idx).wallCount;
            regions = find();
        }
        return res;
    }

    private void updateBlockadedDfs(int[][] temp, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        //  已经遍历的        且  需要封锁
        if (temp[i][j] == 2) {
            grid[i][j] = -1;
            temp[i][j] = -1;
            for (int[] ints : direct) {
                updateBlockadedDfs(temp, i + ints[0], j + ints[1]);
            }
        }
    }

    // 感染
    private void updateInfectedDfs(int[][] temp, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        boolean flag = temp[i][j] == 3;
        //  已经遍历的        或 要感染的
        if (temp[i][j] == 2 || temp[i][j] == 3) {
            grid[i][j] = 1;
            temp[i][j] = 1;
            if (!flag)
                for (int[] ints : direct) {
                    updateInfectedDfs(temp, i + ints[0], j + ints[1]);
                }
        }
    }

    private List<Region> find() {
        List<Region> list = new ArrayList<>();
        // 1. 统计所有病毒感染的区域
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[][] temp = copyGrid(grid); // 2: 访问过的病毒区域 3: 未来要变成的病毒区域
                    dfs(temp, i, j);
                    // 构建region
                    Region region = new Region();
                    region.i = i;
                    region.j = j;
                    region.infected = temp;
                    region.wallCount = wallCount;
                    region.willInfectedCount = willCount;
                    list.add(region);
                    willCount = 0;
                    wallCount = 0;
                }
            }
        }
        return list;
    }

    private int[][] copyGrid(int[][] grid) {
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

    // 每次遍历
    // 把temp的当前访问的病毒区域，访问过的设置为2，即将访问的设置为3
    // 把grid的当前访问的病毒区域，访问过的设置为2
    private void dfs(int[][] temp, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (temp[i][j] == 0 || temp[i][j] == 3) wallCount++;
        if (temp[i][j] == 0) {
            willCount++;
            temp[i][j] = 3;
        } else if (temp[i][j] == 1) {
            temp[i][j] = 2;
            grid[i][j] = 2;
            for (int k = 0; k < direct.length; k++) {
                dfs(temp, i + direct[k][0], j + direct[k][1]);
            }
        }
    }


    static class Region {
        int i, j;
        int[][] infected;
        int willInfectedCount;
        int wallCount;
    }
}
