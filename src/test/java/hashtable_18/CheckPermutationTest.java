package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckPermutationTest {
    @Test
    @DisplayName("check permutation")
    void checkPermutation() {
        CheckPermutation solution = new CheckPermutation();
        assertTrue(solution.checkPermutation("abc", "bca"));
        assertFalse(solution.checkPermutation("a", "ab"));
        assertTrue(solution.checkPermutation1("abc", "bca"));
        assertFalse(solution.checkPermutation1("a", "ab"));
    }
}
