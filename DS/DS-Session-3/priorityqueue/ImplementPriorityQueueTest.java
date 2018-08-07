package datastructure_3.priorityqueue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplementPriorityQueueTest {
    ImplementPriorityQueue queue;

    @Before
    public void init() {
        queue = new ImplementPriorityQueue(new int[] { 4, 5, 2, 9, 1 });
    }

    @Test
    public void test() {
        assertEquals(5, queue.removeProcess());
        assertEquals(3, queue.removeProcess());
        assertEquals(1, queue.removeProcess());
        assertEquals(2, queue.removeProcess());
        assertEquals(4, queue.removeProcess());
    }

}
