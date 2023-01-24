package hw13;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestTaskTwo {
    TaskTwo task = new TaskTwo();

    @Test
    public void maxProduct1() {
        assertEquals(30,task.maxProduct(new int[]{2,4,6,1,7}));
    }

    @Test
    public void maxProduct2(){
        assertEquals(0,task.maxProduct(new int[]{1,1}));
    }
}
