package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 17, 18, 5, 4, 6, 1 };
        int[] expected = new int[] { 18, 6, 6, 6, 1, -1 };

        // when
        int[] result = replaceElements(arr);

        // then
        assertArrayEquals(expected, result);
    }

    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return arr;
        }
        int max = arr[length - 1];
        arr[length - 1] = -1;
        int current = 0;
        for (int i = length - 2; i >= 0; i--) {
            current = arr[i];
            arr[i] = max;
            if (max < current) {
                max = current;
            }
        }
        return arr;
    }
}
