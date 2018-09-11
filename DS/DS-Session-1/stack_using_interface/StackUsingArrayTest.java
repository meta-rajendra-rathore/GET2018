package datastructure_1.stack_using_interface;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure_1.queue_using_interface.QueueUsingArray;

public class StackUsingArrayTest {
    StackUsingArray array;

    public StackUsingArrayTest() {
        array = new StackUsingArray(5);
    }

    @Test
    public void testPopInEmptyQueueAtFirst() {
        assertEquals(-1, array.pop());
    }

    @Test
    public void testPushInEmptyQueueAtFirst() {
        assertEquals(true, array.push(3));
    }

    @Test
    public void testPushInFullQueue() {
        assertEquals(true, array.push(3));
        assertEquals(true, array.push(2));
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(true, array.push(6));
        assertEquals(false, array.push(9));
    }

    @Test
    public void testPushInFullQueueRandom() {
        assertEquals(true, array.push(3));
        assertEquals(true, array.push(2));
        assertEquals(2, array.pop());
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(true, array.push(6));
        assertEquals(6, array.pop());
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(false, array.push(5));
    }

    @Test
    public void testPopInEmptyQueueRandom() {
        assertEquals(true, array.push(3));
        assertEquals(true, array.push(2));
        assertEquals(2, array.pop());
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(true, array.push(6));
        assertEquals(6, array.pop());
        assertEquals(1, array.pop());
        assertEquals(true, array.push(9));
        assertEquals(true, array.push(5));
        assertEquals(5, array.pop());
        assertEquals(9, array.pop());
        assertEquals(4, array.pop());
        assertEquals(3, array.pop());
        assertEquals(-1, array.pop());
    }

    @Test
    public void testPeekInEmptyQueueAtFirst() {
        assertEquals(-1, array.peek());
    }

    @Test
    public void testPeekInEmptyQueueRandom() {
        assertEquals(true, array.push(3));
        assertEquals(true, array.push(2));
        assertEquals(2, array.pop());
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(true, array.push(6));
        assertEquals(6, array.pop());
        assertEquals(1, array.pop());
        assertEquals(true, array.push(9));
        assertEquals(true, array.push(5));
        assertEquals(5, array.pop());
        assertEquals(9, array.pop());
        assertEquals(4, array.pop());
        assertEquals(3, array.pop());
        assertEquals(-1, array.peek());
    }

    @Test
    public void testPeekInQueueRandom() {
        assertEquals(true, array.push(3));
        assertEquals(true, array.push(2));
        assertEquals(2, array.pop());
        assertEquals(true, array.push(4));
        assertEquals(true, array.push(1));
        assertEquals(true, array.push(6));
        assertEquals(6, array.pop());
        assertEquals(1, array.peek());
    }

}
