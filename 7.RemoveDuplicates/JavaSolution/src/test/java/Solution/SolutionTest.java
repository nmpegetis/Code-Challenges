package Solution;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums = new int[] { 1, 2, 2, 2, 3, 3, 4, 5, 5 };
        int[] expected_array = new int[] { 1, 2, 3, 4, 5, 3, 4, 5, 5 };
        int expected_result = 5;

        // when
        int result = removeDuplicates(nums);
        // then
        assertArrayEquals(expected_array, nums);
        assertEquals(expected_result, result);
    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int length = nums.length;
        if (length == 0)
            return 0;
        for (int itr = 1; itr < length; itr++) {
            if (nums[itr] != nums[itr - 1]) {
                nums[count] = nums[itr];
                count++;
            }
        }
        return count;
    }
}
