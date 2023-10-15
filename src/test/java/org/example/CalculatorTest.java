package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @BeforeEach
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void testSum(){
        double first = 2;
        double second = 3;
        double expected = 5;

        assertEquals(expected, calc.sum(first, second));
    }

    @Test
    public void testSub(){
        double first = 7;
        double second = 5;
        double expected = 2;

        assertEquals(expected, calc.sub(first, second));
    }

    @Test
    public void testDel(){
        double first = 10;
        double second = 4;
        double expected = 2.5;

        assertEquals(expected, calc.del(first, second));
    }

    @Test
    public void testMul(){
        double first = 6;
        double second = 2;
        double expected = 12;

        assertEquals(expected, calc.mul(first, second));
    }

    @Test
    public void testDegree(){
        double x = 2;
        double y = 4;
        double expected = 16;

        assertEquals(expected, calc.degree(x, y));
    }

    @Test
    public void testEquation(){
        double a = 1;
        double b = -6;
        double c = 8;

        double[] expected = {2, 4};

        assertArrayEquals(expected, calc.equation(a, b, c));
    }

    @Test
    public void testTransposeMatrix(){
        double [][] matrix = {{1,2}, {3,4}};
        double [][] expected = {{1,3}, {2,4}};

        assertArrayEquals(expected, calc.transposeMatrix(matrix));
    }

    @Test
    public void testInverseMatrix(){
        double [][] matrix = {{1,2}, {3,4}};
        double [][] expected = {{-2,1}, {1.5, -0.5}};

        assertArrayEquals(expected, calc.inverseMatrix(matrix));
    }

    @Test
    public void testDeterminantMatrix(){
        double [][] matrix = {{1,2}, {3,4}};
        double expected = -2;

        assertEquals(expected, calc.determinantMatrix(matrix));
    }

    @Test
    public void testMulMatrix(){
        double [][] matrix1 = {{1,2}, {3,4}};
        double [][] matrix2 = {{9,8}, {7,6}};
        double [][] expected = {{23,20}, {55,48}};

        assertArrayEquals(expected, calc.mulMatrix(matrix1, matrix2));
    }
    @Test
    public void testSumMatrix(){
        double [][] matrix1 = {{1,2}, {3,4}};
        double [][] matrix2 = {{9,8}, {7,6}};
        double [][] expected = {{10,10}, {10,10}};

        assertArrayEquals(expected, calc.sumMatrix(matrix1, matrix2));
        //assertEquals(expected, calc.sumMatrix(matrix1, matrix2));
    }

    @Test
    public void testSubMatrix(){
        double [][] matrix1 = {{1,2}, {3,4}};
        double [][] matrix2 = {{9,8}, {7,6}};
        double [][] expected = {{-8, -6}, {-4,-2}};

        assertArrayEquals(expected, calc.subMatrix(matrix1, matrix2));
    }

    @Test
    public void testMulMatrixWithNum(){
        double [][] matrix1 = {{1,2}, {3,4}};
        double number = 3;
        double [][] expected = {{3,6}, {9,12}};

        assertArrayEquals(expected, calc.mulMatrixWithNum(matrix1, number));
    }

    @Test
    public void testIntegral(){
        String x = "x";
        double lower = 1;
        double upper = 4;
        double expected = 7.5;

        assertEquals(expected, calc.integral(x, lower, upper));
    }

    @Test
    public void testCos(){
        double n = 0.25;
        double expected = 1/ Math.sqrt(2);
        assertTrue(Math.abs( calc.cos(n* Math.PI) - expected) <= 1e-4);
    }

    @Test
    public void testSin(){
        double n = 0.25;
        double expected = 1/ Math.sqrt(2);
        assertTrue(Math.abs( calc.sin(n* Math.PI) - expected) <= 1e-4);
    }

    @Test
    public void testTan(){
        double n = 0.25;
        double expected = 1;
        assertTrue(Math.abs( calc.tan(n* Math.PI) - expected) <= 1e-4);
    }

    @Test
    public void testcotan(){
        double n = 0.25;
        double expected = 1;
        assertTrue(Math.abs( calc.cotan(n* Math.PI) - expected) <= 1e-4);
    }

    @Test
    public void testAsin(){
        double n = 0.5;
        double expected = 30;
        assertEquals(expected, calc.asin(n), 0.000001);
    }

    @Test
    public void testAcos(){
        double n = 0.5;
        double expected = 60;
        assertEquals(expected, calc.acos(n), 0.000001);
    }

    @Test
    public void testAtan(){
        double n = 1;
        double expected = 45;
        assertEquals(expected, calc.atan(n), 0.000001);
    }


}