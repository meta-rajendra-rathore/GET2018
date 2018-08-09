package datastructure_1.stack_using_interface;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackUsingLinkedListTest {
    StackUsingLinkedList stack;

    public StackUsingLinkedListTest() {
        stack = new StackUsingLinkedList();
    }

    @Test
    public void testPopInEmptyStackAtFirst() {
        assertEquals(-1, stack.pop());
    }

    @Test
    public void testPushInEmptyStackAtFirst() {
        assertEquals(true, stack.push(3));
    }

    @Test
    public void testPushPopRandom() {
        assertEquals(true, stack.push(3));
        assertEquals(true, stack.push(2));
        assertEquals(2, stack.pop());
        assertEquals(true, stack.push(4));
        assertEquals(true, stack.push(1));
        assertEquals(true, stack.push(6));
        assertEquals(6, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(true, stack.push(9));
        assertEquals(true, stack.push(5));
        assertEquals(5, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(-1, stack.pop());
    }

    @Test
    public void testPeekInEmptyStackAtFirst() {
        assertEquals(-1, stack.peek());
    }

    @Test
    public void testPeekInEmptyStackRandom() {
        assertEquals(true, stack.push(3));
        assertEquals(true, stack.push(2));
        assertEquals(2, stack.pop());
        assertEquals(true, stack.push(4));
        assertEquals(true, stack.push(1));
        assertEquals(true, stack.push(6));
        assertEquals(6, stack.pop());
        assertEquals(1, stack.pop());
        assertEquals(true, stack.push(9));
        assertEquals(true, stack.push(5));
        assertEquals(5, stack.pop());
        assertEquals(9, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(-1, stack.peek());
    }

    @Test
    public void testPeekInStackRandom() {
        assertEquals(true, stack.push(3));
        assertEquals(true, stack.push(2));
        assertEquals(2, stack.pop());
        assertEquals(3, stack.peek());
        assertEquals(true, stack.push(4));
        assertEquals(true, stack.push(1));
        assertEquals(true, stack.push(6));
        assertEquals(6, stack.pop());
        assertEquals(1, stack.peek());
    }

}
