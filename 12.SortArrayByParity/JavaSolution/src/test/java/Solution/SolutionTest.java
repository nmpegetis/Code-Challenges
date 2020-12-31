package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] arr = new int[] { 3, 1, 2, 4 };
        int[] expected = new int[] { 4, 2, 1, 3 };

        // when
        sortArrayByParity(arr);

        // then
        assertArrayEquals(expected, arr);
    }

    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            if (A[left] % 2 > A[right] % 2) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
            if (A[left] % 2 == 0) {
                left++;
            }
            if (A[right] % 2 == 1) {
                right--;
            }
        }
        return A;
    }
}
