package heaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapTests {

    HeapUtils heapUtils = new HeapUtils();

    @Test
    @DisplayName("Test for total variations of heaps, given num elements")
    public void testNumHeapsIsCorrect(){
        assertEquals(2,heapUtils.numHeaps(3));
        assertEquals(3360,heapUtils.numHeaps(10));
    }
}
