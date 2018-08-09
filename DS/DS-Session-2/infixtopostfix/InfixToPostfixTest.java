package datastructure_2.infixtopostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

    InfixToPostfix infixToPostfix = new InfixToPostfix();
    
    @Test
    public void test_WhenOperandsAreIntegers_ReturnValidOutput() {
        String actualExpression = "( a + ( b * c ) )";
        String expectedExpression = "abc*+";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }

    @Test
    public void test_WhenOperandsAreCapitalCharacters_ReturnValidOutput() {
        String actualExpression = "A * ( B + C ) / D";
        String expectedExpression = "ABC+*D/";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }

    @Test
    public void test_WhenReturnValidOutput() {
        String actualExpression = "A + ( 2 * C - ( D / E - F ) * G ) * H";
        String expectedExpression = "A2C*DE/F-G*-H*+";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }

    @Test
    public void test_WhenOperandsAreSmallCharacters_ReturnValidOutput() {
        String actualExpression = "a * ( b + c ) / d";
        String expectedExpression = "abc+*d/";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }

    @Test
    public void test_WhenOperandsAreBooleanOperators_ReturnValidOutput() {
        String actualExpression = "( a || b ) == ( c && d )";
        String expectedExpression = "ab||cd&&==";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }

    @Test
    public void test_WhenOperandsAreRelationalOperators_ReturnValidOutt() {
        String actualExpression = "a < ( b != c ) == ( d <= e )";
        String expectedExpression = "abc!=<de<===";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }
    
    @Test
    public void test_WhenOperandsAreRandomOperators_ReturnValidOutt() {
        String actualExpression = "a + b < c / d && e == f";
        String expectedExpression = "ab+cd/<ef==&&";
        assertEquals(expectedExpression, infixToPostfix.convertToPostFix(actualExpression));
    }
}