package Solution;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < nums.length; j++) {
            set.add(nums[j]);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.contains(i) == false) {
                list.add(i);
            }
        }
        return list;
    }
}
