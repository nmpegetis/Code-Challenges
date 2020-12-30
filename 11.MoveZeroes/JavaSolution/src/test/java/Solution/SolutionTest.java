package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 0, 1, 0, 3, 12 };
        int[] expected = new int[] { 1, 3, 12, 0, 0 };

        // when
        moveZeroes(arr);

        // then
        assertArrayEquals(expected, arr);
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length > 1) {
            int write = 0;
            for (int read = 0; read < length; read++) {
                if (nums[read] != 0) {
                    nums[write] = nums[read];
                    write++;
                }
            }
            for (int i = write; i < length; i++) {
                nums[i] = 0;
            }
        }
    }
}
