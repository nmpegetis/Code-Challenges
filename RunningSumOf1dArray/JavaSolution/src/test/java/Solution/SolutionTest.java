package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void shouldAnswerWithTrue() {
        // given
        int[] array = new int[] { 1, 2, 3, 4 };
        int[] matcher = new int[] { 1, 3, 6, 10 };

        // when
        int[] runningSum = runningSum(array);

        // then
        assertArrayEquals(runningSum, matcher);
    }

    private int[] runningSum(int[] nums) {
        return sum(new int[nums.length], 0, nums);
    }

    private int[] sum(int[] currentSum, int position, int[] arr) {
        if (position > 0) {
            currentSum[position] += currentSum[position - 1];
        }
        currentSum[position] += arr[position];
        if (position < arr.length - 1) {
            return sum(currentSum, ++position, arr);
        }
        return currentSum;
    }

}
