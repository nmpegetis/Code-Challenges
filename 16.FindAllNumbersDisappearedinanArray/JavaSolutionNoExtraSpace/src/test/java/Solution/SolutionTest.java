package Solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(6);

        // when
        List<Integer> result = findDisappearedNumbers(arr);

        // then
        assertEquals(expected, result);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            // The key for no extra space is to make use of the indices as if the are the
            // numbers and mark the visited as negative ones
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {
            // the positive ones are the ones that are never visited and so the ones we need
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}
