package datastructure_3.priorityqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplementPriorityQueueTest {
    ImplementPriorityQueue queue;

    @Before
    public void init() {
        queue = new ImplementPriorityQueue(5);
        queue.addProcess(4);
        queue.addProcess(5);
        queue.addProcess(2);
        queue.addProcess(9);
        queue.addProcess(1);
    }

    @Test
    public void testRemoval() {
        assertEquals(9, queue.removeProcess());
        assertEquals(5, queue.removeProcess());
        assertEquals(4, queue.removeProcess());
        assertEquals(2, queue.removeProcess());
        assertEquals(1, queue.removeProcess());
    }

    @Test
    public void testRemovalBeyondLimit() {
        assertEquals(9, queue.removeProcess());
        assertEquals(5, queue.removeProcess());
        assertEquals(4, queue.removeProcess());
        assertEquals(2, queue.removeProcess());
        assertEquals(1, queue.removeProcess());
        assertEquals(-1, queue.removeProcess());
    }

}
