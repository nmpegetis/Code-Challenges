package Solution;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 2, 2, 3, 1 };
        int expected = 1;

        // when
        int result = thirdMax(arr);

        // then
        assertEquals(expected, result);
    }

    public int thirdMax(int[] nums) {
        Set<Integer> maximums = new HashSet<Integer>();
        for (int num : nums) {
            maximums.add(num);
            if (maximums.size() > 3) {
                maximums.remove(Collections.min(maximums));
            }
        }
        if (maximums.size() == 3) {
            return Collections.min(maximums);
        }
        return Collections.max(maximums);
    }
}
