package hw12;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestTaskOne {

    @Test
    public void numJewelsInStones1() {
        TaskOne object = new TaskOne();
        assertEquals(3, object.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    public void numJewelsInStones2(){
        TaskOne test = new TaskOne();
        assertEquals(0, test.numJewelsInStones("x", "XX"));
    }

    @Test
    public void numJewelsInStones3() {
        TaskOne test = new TaskOne();
        assertNotEquals(2, test.numJewelsInStones("k", "kyi"));
    }

}
