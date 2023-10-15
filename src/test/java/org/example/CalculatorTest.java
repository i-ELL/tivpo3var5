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

}