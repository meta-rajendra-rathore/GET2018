package adt_cdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {
    Poly poly1 = new Poly(new int[][]{ {0, 2}, {4, 2}, {2, 3}});

    @Test
    public void testEvaluate() {
        assertEquals(46.0, poly1.evaluate(2.0F), 0.001);
    }

    @Test
    public void testDegree() {
        assertEquals(4, poly1.degree());
    }

    @Test
    public void testAddPoly() {
        Poly poly2 = new Poly(new int[][]{ {0, 1}, {4, 3}, {2, 2}});
        assertArrayEquals(new int[][]{ {0, 3}, {4, 5}, {2, 5}}, Poly.addPoly(poly1, poly2)); 
    }

    @Test
    public void testMultiplyPoly() {
        Poly poly2 = new Poly(new int[][]{ {0, 2}, {2, 3}});
        assertArrayEquals(new int[][]{ {0, 4}, {2, 12}, {4, 13}, {6, 6}}, Poly.multiplyPoly(poly1, poly2));
    }

}
