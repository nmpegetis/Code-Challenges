package Solution;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] zerosOnes = new int[] { 1, 0, 1, 1, 0, 1, 1, 1 };

        // when
        int maxConsecutiveOnes = findMaxConsecutiveOnes(zerosOnes);

        // then
        assertEquals(3, maxConsecutiveOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int el : nums) {
            if (el == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
