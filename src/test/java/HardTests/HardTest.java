package HardTests;
import hw14.HardTasks.Hard;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class HardTest {
    Hard task = new Hard();
     static String[] words = {"oneone", "asasasv"};


    @Test
    public void hardTestOne() {
        assertEquals(true,task.findAllConcatenatedWordsInADict(words));
    }
}
