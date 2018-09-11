package datastructure_1.queue_using_interface;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueUsingLinkedListTest {
    QueueUsingLinkedList queue;

    public QueueUsingLinkedListTest() {
        queue = new QueueUsingLinkedList();
    }

    @Test
    public void testDequeueInEmptyQueueAtFirst() {
        assertEquals(-1, queue.dequeue());
    }

    @Test
    public void testEnqueueInEmptyQueueAtFirst() {
        assertEquals(true, queue.enqueue(3));
    }

    @Test
    public void testEnqueueDequeueRandom() {
        assertEquals(true, queue.enqueue(3));
        assertEquals(true, queue.enqueue(2));
        assertEquals(3, queue.dequeue());
        assertEquals(true, queue.enqueue(4));
        assertEquals(true, queue.enqueue(1));
        assertEquals(true, queue.enqueue(6));
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(true, queue.enqueue(9));
        assertEquals(true, queue.enqueue(5));
        assertEquals(1, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(-1, queue.dequeue());
    }

    @Test
    public void testPeekInEmptyQueueAtFirst() {
        assertEquals(-1, queue.peek());
    }

    @Test
    public void testPeekInEmptyQueueRandom() {
        assertEquals(true, queue.enqueue(3));
        assertEquals(true, queue.enqueue(2));
        assertEquals(3, queue.dequeue());
        assertEquals(true, queue.enqueue(4));
        assertEquals(true, queue.enqueue(1));
        assertEquals(true, queue.enqueue(6));
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(true, queue.enqueue(9));
        assertEquals(true, queue.enqueue(5));
        assertEquals(1, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(-1, queue.peek());
    }

    @Test
    public void testPeekInQueueRandom() {
        assertEquals(true, queue.enqueue(3));
        assertEquals(true, queue.enqueue(2));
        assertEquals(3, queue.dequeue());
        assertEquals(true, queue.enqueue(4));
        assertEquals(true, queue.enqueue(1));
        assertEquals(true, queue.enqueue(6));
        assertEquals(2, queue.dequeue());
        assertEquals(4, queue.peek());
    }

}
