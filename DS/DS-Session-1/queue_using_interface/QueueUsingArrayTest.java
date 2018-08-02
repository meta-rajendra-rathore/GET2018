package datastructure_1.queue_using_interface;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueUsingArrayTest {
    QueueUsingArray array;

    public QueueUsingArrayTest() {
        array = new QueueUsingArray(5);
    }

    @Test
    public void testdequeueInEmptyQueueAtFirst() {
        assertEquals(-1, array.dequeue());
    }

    @Test
    public void testEnqueueInEmptyQueueAtFirst() {
        assertEquals(true, array.enqueue(3));
    }

    @Test
    public void testEnqueueInFullQueue() {
        assertEquals(true, array.enqueue(3));
        assertEquals(true, array.enqueue(2));
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(true, array.enqueue(6));
        assertEquals(false, array.enqueue(9));
    }

    @Test
    public void testEnqueueInFullQueueRandom() {
        assertEquals(true, array.enqueue(3));
        assertEquals(true, array.enqueue(2));
        assertEquals(3, array.dequeue());
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(true, array.enqueue(6));
        assertEquals(2, array.dequeue());
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(false, array.enqueue(5));
    }

    @Test
    public void testdequeueInEmptyQueueRandom() {
        assertEquals(true, array.enqueue(3));
        assertEquals(true, array.enqueue(2));
        assertEquals(3, array.dequeue());
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(true, array.enqueue(6));
        assertEquals(2, array.dequeue());
        assertEquals(4, array.dequeue());
        assertEquals(true, array.enqueue(9));
        assertEquals(true, array.enqueue(5));
        assertEquals(1, array.dequeue());
        assertEquals(6, array.dequeue());
        assertEquals(9, array.dequeue());
        assertEquals(5, array.dequeue());
        assertEquals(-1, array.dequeue());
    }

    @Test
    public void testPeekInEmptyQueueAtFirst() {
        assertEquals(-1, array.peek());
    }

    @Test
    public void testPeekInEmptyQueueRandom() {
        assertEquals(true, array.enqueue(3));
        assertEquals(true, array.enqueue(2));
        assertEquals(3, array.dequeue());
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(true, array.enqueue(6));
        assertEquals(2, array.dequeue());
        assertEquals(4, array.dequeue());
        assertEquals(true, array.enqueue(9));
        assertEquals(true, array.enqueue(5));
        assertEquals(1, array.dequeue());
        assertEquals(6, array.dequeue());
        assertEquals(9, array.dequeue());
        assertEquals(5, array.dequeue());
        assertEquals(-1, array.peek());
    }

    @Test
    public void testPeekInQueueRandom() {
        assertEquals(true, array.enqueue(3));
        assertEquals(true, array.enqueue(2));
        assertEquals(3, array.dequeue());
        assertEquals(true, array.enqueue(4));
        assertEquals(true, array.enqueue(1));
        assertEquals(true, array.enqueue(6));
        assertEquals(2, array.dequeue());
        assertEquals(4, array.peek());
    }

}
