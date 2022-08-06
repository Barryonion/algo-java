package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IsAnagramTest {
    @Test
    @DisplayName("is anagram")
    void isAnagram() {
        IsAnagram solution = new IsAnagram();
        assertTrue(solution.isAnagram("anagram", "nagaram"));
        assertFalse(solution.isAnagram("rat", "car"));
    }
}
