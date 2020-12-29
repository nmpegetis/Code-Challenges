package Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr1 = new int[] { 3, 5, 5, 2 };
        int[] arr2 = new int[] { 0, 3, 2, 1 };

        // when
        boolean result1 = validMountainArray(arr1);
        boolean result2 = validMountainArray(arr2);

        // then
        assertFalse(result1);
        assertTrue(result2);
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1]) {
            return false;
        }
        int i = 1;
        while (i < arr.length - 1 && arr[i - 1] < arr[i]) {
            i++;
        }
        while (i < arr.length && arr[i - 1] > arr[i]) {
            i++;
        }
        if (i == arr.length)
            return true;
        return false;
    }
}
