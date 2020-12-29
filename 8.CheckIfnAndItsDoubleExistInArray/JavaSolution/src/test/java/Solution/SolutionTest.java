package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr1 = new int[] { 10, 2, 5, 3 };
        int[] arr2 = new int[] { 1, 3, 7, 11 };

        // when
        boolean result1 = checkIfExist(arr1);
        boolean result2 = checkIfExist(arr2);

        // then
        assertTrue(result1);
        assertFalse(result2);
    }

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> ht = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && (ht.containsKey(arr[i] / 2)) || ht.containsKey(arr[i] * 2)) {
                return true;
            }
            ht.put(arr[i], i);
        }
        return false;
    }
}
