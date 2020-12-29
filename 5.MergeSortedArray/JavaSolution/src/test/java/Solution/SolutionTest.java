package Solution;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = new int[] { 4, 5, 6 };
        int n = 3;
        int[] expected = new int[] { 1, 2, 3, 4, 5, 6 };

        // when
        merge(nums1, m, nums2, n);
        // then
        assertArrayEquals(expected, nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = nums1.length - n - 1;
        int p2 = nums2.length - 1;
        int arrayPointer = nums1.length - 1;
        while (arrayPointer >= 0 && (arrayPointer >= 0 && p2 >= 0)) {
            if (p1 < 0) {
                p1 = 0;
                nums1[p1] = Integer.MIN_VALUE;
            }
            if (p2 < 0) {
                p2 = 0;
                nums2[p2] = Integer.MIN_VALUE;
            }
            if (nums1[p1] >= nums2[p2]) {
                nums1[arrayPointer] = nums1[p1];
                p1--;
            } else {
                nums1[arrayPointer] = nums2[p2];
                p2--;
            }
            arrayPointer--;
        }
    }
}
