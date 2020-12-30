package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums = new int[] { 12, 345, 2, 6, 7896 };

        // when
        int countOfEvenDigitNums = findNumbers(nums);

        // then
        assertEquals(2, countOfEvenDigitNums);
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int times = 0;
            while (num != 0) {
                num /= 10;
                times++;
            }
            if (times % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
