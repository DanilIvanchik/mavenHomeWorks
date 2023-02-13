package hw14;

import hw14.TaskTwo;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestTaskTwo {
    TaskTwo task = new TaskTwo();

    @Test
    public void isHappyTestOne() {
        assertEquals(true,task.isHappy(1111111));
    }

    @Test
    public void isHappyTestTwo() {
        assertEquals(true,task.isHappy(19));
    }

    @Test
    public void isHappyTestThree() {
        assertEquals(false,task.isHappy(2));
    }
}
