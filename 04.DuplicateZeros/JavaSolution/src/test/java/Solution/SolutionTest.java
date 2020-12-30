package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums = new int[] { 1, 0, 2, 3, 0, 4, 5, 0 };
        int[] expected = new int[] { 1, 0, 0, 2, 3, 0, 0, 4 };

        // when
        duplicateZeros(nums);
        // then
        assertArrayEquals(expected, nums);
    }

    // for space O(1)
    public void duplicateZeros(int[] arr) {
        int countDupZeros = 0;
        int length = arr.length - 1;
        for (int i = 0; i <= length - countDupZeros; i++) {
            if (arr[i] == 0) {
                if (i == length - countDupZeros) {
                    // we already here set the last element to zero and won't iterate on it later
                    arr[length] = 0;
                    length--;
                    break;
                }
                countDupZeros++;
            }
        }
        for (int i = length; i >= 0; i--) {
            int el = arr[i - countDupZeros];
            if (el != 0) {
                arr[i] = el;
            } else {
                arr[i] = 0;
                if (i > 0)
                    arr[i - 1] = 0;
                i--;
                countDupZeros--;
            }
        }
    }
}
