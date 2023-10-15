package org.example;

import java.util.Scanner;

public class Main {

    public static double[][] inputMatrix(){
        Scanner in =  new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int rows = in.nextInt();
        System.out.print("Введите количество столбцов: ");
        int columns = in.nextInt();
        double[][] matrix = new double[rows][columns];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        return matrix;
    }
    public static void outputMatrix(double[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        Calculator calc = new Calculator();

        Scanner in =  new Scanner(System.in);
        int n = 1;
        while(n != 0) {

            System.out.println("Матричный калькутор\nВведите действия для выполнения:\n" +
                    "0 - Транспанирование\n" +
                    "1 - Сложение двух матриц\n" +
                    "2 - Вычитание двух матриц\n" +
                    "3 - Умножение двух матриц\n" +
                    "4 - Умножение матрицы на число\n" +
                    "5 - Определитель\n" +
                    "6 - Обратная матрица\n"
            );

            n = in.nextInt();
            switch (n){

                case 0: {
                    double[][] matrix = inputMatrix();
                    double[][] new_matrix = calc.transposeMatrix(matrix);
                    outputMatrix(new_matrix);
                };break;
                case 1: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.sumMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 2: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.subMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 3: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.mulMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 4: {
                    double[][] matrix1 = inputMatrix();
                    double num = in.nextDouble();

                    double[][] new_matrix = calc.mulMatrixWithNum(matrix1, num);
                    outputMatrix(new_matrix);
                };break;
                case 5: {
                    double[][] matrix1 = inputMatrix();

                    System.out.println("Определитель: " +  calc.determinantMatrix(matrix1));
                };break;
                case 6: {
                    double[][] matrix1 = inputMatrix();

                    double[][] new_matrix = calc.inverseMatrix(matrix1);
                    outputMatrix(new_matrix);
                };break;


            }

        }

    }
}