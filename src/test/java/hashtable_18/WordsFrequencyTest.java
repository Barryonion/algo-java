package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("fast")
public class WordsFrequencyTest {

    @Test
    @DisplayName("get words frequency")
    void getWordsFrequency(TestInfo testInfo) {
        String[] book = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency solution = new WordsFrequency(book);
        assertEquals(2,solution.get("have"),"has two word 'have'");
        assertEquals(1, solution.get("he"), "has one word 'have'");
    }
}
