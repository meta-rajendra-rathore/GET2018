package adt_cdt;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {
    Poly poly1 = new Poly(new int[]{4, 2, 1, 2});

    @Test
    public void testEvaluate() {
        assertEquals(28.0, poly1.evaluate(2.0F), 0.001);
    }

    @Test
    public void testDegree() {
        assertEquals(4, poly1.degree());
    }

    @Test
    public void testAddPoly() {
        Poly poly2 = new Poly(new int[]{3, 5, 4});
        assertArrayEquals(new int[]{7, 7, 5, 2}, poly1.addPoly(poly1, poly2));
    }

    @Test
    public void testMultiplyPoly() {
        Poly poly2 = new Poly(new int[]{2, 1, 3});
        assertArrayEquals(new int[]{8, 8, 16, 11, 5, 6}, poly1.multiplyP(poly1, poly2));
        
        Poly poly3 = new Poly(new int[]{1, 3});
        assertArrayEquals(new int[]{4, 14, 7, 5, 6}, poly1.multiplyP(poly1, poly3));
    }

}
