/**
 * The class provide unit tests for CountUniqueChar class
 */
package datastructure_4.uniquecharacters;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Rajendra Singh Rathore
 *
 */
public class CountUniqueCharTest {
    CountUniqueChar countUniqueChar = new CountUniqueChar();

    @Test
    public void countUniqueCharInEmptyString() {
        assertEquals(0, countUniqueChar.getNoOfUniqueChar(""));
    }
    
    @Test (expected = AssertionError.class)
    public void countUniqueCharInNull() {
        assertEquals(new AssertionError(), countUniqueChar.getNoOfUniqueChar(null));
    }
    
    @Test
    public void countUniqueCharInUniqueString() {
        assertEquals(9, countUniqueChar.getNoOfUniqueChar("This name"));
    }
    
    @Test
    public void countUniqueCharInNotUniqueString() {
        assertEquals(4, countUniqueChar.getNoOfUniqueChar("abcdeff f a"));
        assertEquals(7, countUniqueChar.getNoOfUniqueChar("This name is not unique"));
    }
    
    @Test
    public void getCountUsingCacheIfRepeatedString() {
        assertEquals(9, countUniqueChar.getNoOfUniqueChar("This name"));
        assertEquals(7, countUniqueChar.getNoOfUniqueChar("This name is not unique"));
        assertEquals(9, countUniqueChar.getNoOfUniqueChar("This name"));
    }

}
