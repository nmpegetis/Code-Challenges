package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        int expected = 4;

        // when
        int result = findMaxConsecutiveOnes(arr);

        // then
        assertEquals(expected, result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zeroes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroes++;
            }

            while (zeroes == 2) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }
        return max;
    }
}
