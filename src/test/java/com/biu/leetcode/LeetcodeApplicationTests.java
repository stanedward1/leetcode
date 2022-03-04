package com.biu.leetcode;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LeetcodeApplicationTests {

    @Test
    void T2104() {
        T2104 solution = new T2104();
        long result = solution.subArrayRanges(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

}
