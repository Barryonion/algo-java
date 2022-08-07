package hashtable_18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindSwapValuesTest {
    @Test
    @DisplayName("find swap value")
    void findSwapValue() {
        FindSwapValues solution = new FindSwapValues();
        int[] array1 = {1, 4, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        int[] array3 = {519, 886, 282, 382, 662, 4718, 258, 719, 494, 795};
        int[] array4 = {52, 20, 78, 50, 38, 96, 81, 20};
        int[] swapValues = solution.findSwapValues(array3, array4);
        List<Integer> resultList = Arrays.stream(swapValues).boxed().collect(Collectors.toList());
        System.out.println(resultList);
    }
}
