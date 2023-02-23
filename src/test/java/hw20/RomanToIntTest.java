package hw20;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanToIntTest {
    Solution romanNumbers = new Solution();

    @Test
    public void romanConverterTestOne(){
        Assertions.assertEquals(1994, romanNumbers.innerSolution("MCMXCIV"));

    }

    @Test
    public void romanConverterTestTwo(){
        Assertions.assertEquals(3, romanNumbers.innerSolution("III"));

    }

    @Test
    public void romanConverterTestThree(){
        Assertions.assertEquals(58, romanNumbers.innerSolution("LVIII"));

    }
}
