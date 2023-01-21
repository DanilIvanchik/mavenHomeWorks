package hw12;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestTaskTwo {
    @Test
    public void numIdenticalPairs1() {
        TaskTwo object = new TaskTwo();
        assertEquals(4, object.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
    @Test
    public void numIdenticalPairs2() {
        TaskTwo object = new TaskTwo();
        assertEquals(0, object.numIdenticalPairs(new int[]{1, 2, 3}));
    }

    @Test
    public void numIdenticalPairs3() {
        TaskTwo object = new TaskTwo();
        assertEquals(6, object.numIdenticalPairs(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void numIdenticalPairs4() {
        TaskTwo object = new TaskTwo();
        assertNotEquals(5, object.numIdenticalPairs(new int[]{1, 1, 1, 1}));
    }
}
