package hw13;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TestTaskOne {

    TaskOne taskOne = new TaskOne();
    int[] nums = new int[]{-3,2,0,10,4,-5};

    @Test
    public void sortedSquaresTest() {
        taskOne.sortedSquares(nums);
        assertEquals(0,nums[0]);
    }

    @Test
    public void sortedSquares2() {
        taskOne.sortedSquares(nums);
        assertEquals(100,nums[nums.length-1]);
    }
}
