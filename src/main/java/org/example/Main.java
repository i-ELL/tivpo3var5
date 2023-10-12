package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Calculator calc = new Calculator();
        double [][] matrix = {{1,2}, {3,4}, {5, 6}};
        double[][] m =  calc.mulMatrixWithNum(matrix, 3);
    }
}