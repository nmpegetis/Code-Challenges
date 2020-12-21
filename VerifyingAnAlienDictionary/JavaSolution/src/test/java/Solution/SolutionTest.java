package Solution;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void shouldAnswerWithTrue() {
        // given
        String[] words1 = new String[] { "word", "world", "row" };
        String order1 = "worldabcefghijkmnpqstuvxyz";
        String[] words2 = new String[] { "apple", "app" };
        String order2 = "abcdefghijklmnopqrstuvwxyz";
        String[] words3 = new String[] { "bob", "alice" };
        String order3 = "bacdefghijklmnopqrstuvwxyz";

        // when
        boolean firstSet = isAlienSorted(words1, order1);
        boolean secondSet = isAlienSorted(words2, order2);
        boolean thirdSet = isAlienSorted(words3, order3);

        // then
        assertFalse(firstSet);
        assertFalse(secondSet);
        assertTrue(thirdSet);
    }

    int[] hashmap = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            hashmap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isBefore(words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    private boolean isBefore(String word1, String word2) {
        String shortestWord = word1.length() <= word2.length() ? word1 : word2;
        for (int i = 0; i < shortestWord.length(); i++) {
            int i1 = hashmap[word1.charAt(i) - 'a'];
            int i2 = hashmap[word2.charAt(i) - 'a'];
            if (i1 == i2)
                continue;
            return i1 <= i2;
        }
        return word1.length() <= word2.length();
    }
}
