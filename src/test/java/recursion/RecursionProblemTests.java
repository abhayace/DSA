package recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import recursioin.RecursionProblems;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecursionProblemTests {

    RecursionProblems recursionProblems = new RecursionProblems();

    @Test
    @DisplayName("permutation return n! strings")
    public void testStringPermutationReturnsNFactStrings(){
        String testString = "abcd";
        assertEquals(24, recursionProblems.stringPermutations(testString).size());
    }


    @Test
    @DisplayName("all subsets are returned ")
    public void testAllSubsetsAreGenerated(){
        List<String> products = new ArrayList();
        for (int i=0;i<4;i++){
            products.add("P"+i);
        }
        List<List<String>> allsubsets = recursionProblems.getAllSubsets(products);
        System.out.println(allsubsets);
        assertEquals(16, allsubsets.size());
    }
}
