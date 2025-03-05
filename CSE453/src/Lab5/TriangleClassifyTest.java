package Lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleClassifyTest {

	@Test
    public void testEquilateral() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 100);
        assertEquals("EQUILATERAL", triangle.classify());
    }

    @Test
    public void testIsosceles() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 50);
        assertEquals("ISOSCELES", triangle.classify());
    }

    @Test
    public void testScalene() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(3, 4, 5);
        assertEquals("SCALENE", triangle.classify());
    }

    @Test
    public void testNotATriangle() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 50, 50);
        assertEquals("IsNotTriangle", triangle.classify());
    }

    @Test
    public void testSide1Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(1, 100, 100);
        assertEquals("ISOSCELES", triangle.classify());
    }

    @Test
    public void testSide1Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(200, 100, 100);
        assertEquals("IsNotTriangle", triangle.classify());
    }

    @Test
    public void testSide2Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 1, 100);
        assertEquals("ISOSCELES", triangle.classify());
    }

    @Test
    public void testSide2Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 200, 100);
        assertEquals("IsNotTriangle", triangle.classify());
    }

    @Test
    public void testSide3Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 1);
        assertEquals("ISOSCELES", triangle.classify());
    }

    @Test
    public void testSide3Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 200);
        assertEquals("IsNotTriangle", triangle.classify());
    }

    @Test
    public void testAllMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(1, 1, 1);
        assertEquals("EQUILATERAL", triangle.classify());
    }

    @Test
    public void testAllMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(200, 200, 200);
        assertEquals("EQUILATERAL", triangle.classify());
    }

    @Test
    public void testNominalValues() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 100);
        assertEquals("EQUILATERAL", triangle.classify());
    }

    // Robust BVA Test Cases (19)
    @Test
    public void testRobustSide1BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 100, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 100, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 0, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 201, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide3BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 0);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide3AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 100, 201);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustAllBelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 0, 0);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustAllAboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 201, 201);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1BelowMinSide2Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 1, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1BelowMinSide3Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 100, 1);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2BelowMinSide3Min() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 0, 1);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1AboveMaxSide2Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 200, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1AboveMaxSide3Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 100, 200);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2AboveMaxSide3Max() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 201, 200);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1BelowMinSide2AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 201, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1BelowMinSide3AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(0, 100, 201);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2BelowMinSide3AboveMax() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 0, 201);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1AboveMaxSide2BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 0, 100);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide1AboveMaxSide3BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(201, 100, 0);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }

    @Test
    public void testRobustSide2AboveMaxSide3BelowMin() {
        TriangleClassify triangle = new TriangleClassify();
        triangle.setSide(100, 201, 0);
        assertEquals("OUT_OF_RANGE", triangle.classify());
    }
}
