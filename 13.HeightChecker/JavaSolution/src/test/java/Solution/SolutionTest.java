package Solution;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr1 = new int[] { 5, 1, 2, 3, 4 };
        int[] arr2 = new int[] { 5, 2, 3, 1, 4 };
        int expected1 = 5;
        int expected2 = 3;

        // when
        int result1 = heightChecker(arr1);
        int result2 = heightChecker(arr2);

        // then
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }

    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}
