package Solution;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums = new int[] { -4, -1, 0, 3, 10 };
        int[] expected = new int[] { 0, 1, 9, 16, 100 };

        // when
        int[] output = sortedSquares(nums);

        // then
        assertArrayEquals(expected, output);
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
