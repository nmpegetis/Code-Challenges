package Solution;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        // given
        String given1 = "abcba";
        String given2 = "abba";

        // when
        int result1 = firstUniqChar(given1);
        int result2 = firstUniqChar(given2);

        // then
        assertEquals(2, result1);
        assertEquals(-1, result2);
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
