package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {
    @Test
    @DisplayName("group anagram test")
    void groupAnagrams() {
        GroupAnagrams solution = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strs));
    }

}
