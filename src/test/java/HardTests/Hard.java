package HardTests;
import HardTasks.Hard;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HardTest {
    Hard task = new Hard();


    @Test
    public void hardTestOne() {
        assertEquals(true,task.findAllConcatenatedWordsInADict());
    }
}
