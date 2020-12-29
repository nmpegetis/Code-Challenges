package Solution;

import static org.junit.Assert.assertArrayEquals;

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
        int[] sortedSquares = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int position = nums.length - 1;
        while (start != end) {
            // calculate squares on both sides
            int leftMostSquare = nums[start] * nums[start];
            int rightMostSquare = nums[end] * nums[end];
            if (leftMostSquare >= rightMostSquare) {
                sortedSquares[position] = leftMostSquare;
                start++;
            } else {
                sortedSquares[position] = rightMostSquare;
                end--;
            }
            position--;
        }
        sortedSquares[position] = nums[end] * nums[end];

        return sortedSquares;
    }
}
