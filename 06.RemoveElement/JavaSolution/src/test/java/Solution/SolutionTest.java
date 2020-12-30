package Solution;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums = new int[] { 3, 2, 2, 2, 3 };
        int val = 2;
        int[] expected_array = new int[] { 3, 3, 2, 2, 3 };
        int expected_result = 2;

        // when
        int result = removeElement(nums, val);
        // then
        assertArrayEquals(expected_array, nums);
        assertEquals(expected_result, result);
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int length = nums.length;
        for (int itr = 0; itr < length; itr++) {
            if (nums[itr] != val) {
                nums[count] = nums[itr];
                count++;
            }
        }
        return count;
    }
}
