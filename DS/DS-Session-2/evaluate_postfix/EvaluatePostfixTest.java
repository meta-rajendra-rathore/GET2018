package datastructure_2.evaluate_postfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluatePostfixTest {

    @Test
    public void testWithTwoElementsInStack() {
        EvaluatePostfix expsn = new EvaluatePostfix("9 1 + 2 - 3 *");
        expsn.evaluate();
        assertEquals("24", expsn.getResult());
    }
    
    @Test
    public void testWithMoreThanTwoElementsInStack() {
        EvaluatePostfix expsn = new EvaluatePostfix("5 6 2 + * 12 4 / -");
        expsn.evaluate();
        assertEquals("37", expsn.getResult());
    }
    
    @Test
    public void testWithLessThanTwoElementsInStack() {
        EvaluatePostfix expsn = new EvaluatePostfix("5 6 + 2 + * 12 4 / -");
        expsn.evaluate();
        assertEquals("Invalid Expression!", expsn.getResult());
    }
    
    @Test
    public void testWithInvalidOperator() {
        EvaluatePostfix expsn = new EvaluatePostfix("5 6 + 2 & * 12 4 / -");
        expsn.evaluate();
        assertEquals("Invalid Expression!", expsn.getResult());
    }
    
    @Test
    public void testWithMoreThanTwoElementsInStack2() {
        EvaluatePostfix expsn = new EvaluatePostfix("1 5 6 + 2 + * 12 4 / -");
        expsn.evaluate();
        assertEquals("10", expsn.getResult());
    }
}
