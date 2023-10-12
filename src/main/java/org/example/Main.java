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

            System.out.println("ПРОГРАММА: НАУЧНЫЙ КАЛЬКУЛЯТОР\nВведите действия для выполнения:\n" +
                    "0 - прервать программу\n" +
                    "1 - Сложение\n" +
                    "2 - Вычитание\n" +
                    "3 - Умножение\n" +
                    "4 - Деление\n" +
                    "5 - Возведение в степень\n" +
                    "6 - Решение уравнения\n" +
                    "7 - Матричные операции. Транспанирование\n" +
                    "8 - Матричные операции. Сложение двух матриц\n" +
                    "9 - Матричные операции. Вычитание двух матриц\n" +
                    "10 - Матричные операции. Умножение двух матриц\n" +
                    "11 - Матричные операции. Умножение матрицы на число\n" +
                    "12 - Матричные операции. Определитель\n" +
                    "13 - Матричные операции. Обратная матрица\n" +
                    "14 - Найти интеграл\n" +
                    "15 - sin\n" +
                    "16 - cos\n" +
                    "17 - tan\n" +
                    "18 - ctg\n" +
                    "19 - atan\n" +
                    "20 - acos\n" +
                    "21 - asin\n" +
                    ""
            );

            n = in.nextInt();
            switch (n){
                case 0:{
                    System.out.println("ПРОГРАММА ЗАВЕРШЕНА");
                };break;
                case 1:{
                    System.out.print("Введите первое число:");
                    double first = in.nextDouble();
                    System.out.print("Введите второе число:");
                    double second = in.nextDouble();
                    System.out.println("Сумма: " + calc.sum(first, second));
                };break;
                case 2:{
                    System.out.print("Введите первое число:");
                    double first = in.nextDouble();
                    System.out.print("Введите второе число:");
                    double second = in.nextDouble();
                    System.out.println("Разность: " + calc.sub(first, second));
                };break;
                case 3:{
                    System.out.print("Введите первое число:");
                    double first = in.nextDouble();
                    System.out.print("Введите второе число:");
                    double second = in.nextDouble();
                    System.out.println("Умножение: " + calc.mul(first, second));
                };break;
                case 4:{
                    System.out.print("Введите первое число:");
                    double first = in.nextDouble();
                    System.out.print("Введите второе число:");
                    double second = in.nextDouble();
                    System.out.println("Частное: " + calc.sum(first, second));
                };break;
                case 5:{
                    System.out.print("Введите первое число:");
                    double first = in.nextDouble();
                    System.out.print("Введите второе число:");
                    double second = in.nextDouble();
                    System.out.println("Возведение в степень: " + calc.degree(first, second));
                };break;
                case 6:{
                    System.out.print("Введите аргументы уравнения a, b, c вида ax^2 + bx + c = 0");
                    double a = in.nextDouble();
                    double b = in.nextDouble();
                    double c = in.nextDouble();
                    System.out.println("Корни: " + calc.equation(a, b, c));
                };break;
                case 7: {
                    double[][] matrix = inputMatrix();
                    double[][] new_matrix = calc.transposeMatrix(matrix);
                    outputMatrix(new_matrix);
                };break;
                case 8: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.sumMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 9: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.subMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 10: {
                    double[][] matrix1 = inputMatrix();
                    double[][] matrix2 = inputMatrix();

                    double[][] new_matrix = calc.mulMatrix(matrix1, matrix2);
                    outputMatrix(new_matrix);
                };break;
                case 11: {
                    double[][] matrix1 = inputMatrix();
                    double num = in.nextDouble();

                    double[][] new_matrix = calc.mulMatrixWithNum(matrix1, num);
                    outputMatrix(new_matrix);
                };break;
                case 12: {
                    double[][] matrix1 = inputMatrix();

                    System.out.println("Определитель: " +  calc.determinantMatrix(matrix1));
                };break;
                case 13: {
                    double[][] matrix1 = inputMatrix();

                    double[][] new_matrix = calc.inverseMatrix(matrix1);
                    outputMatrix(new_matrix);
                };break;
                case 14: {
                    System.out.println("Введите интеграл (используйте х для обозначения переменной)");
                    String s = in.nextLine();
                    System.out.println("Ввведите нижний предел интегрирования");
                    double low = in.nextDouble();
                    System.out.println("Ввведите верхний предел интегрирования");
                    double up = in.nextDouble();
                    System.out.println("Результат интегрирвания: " + calc.integral(s, low, up));
                };break;
                case 15:{
                    System.out.println("Введите аргумент в радианах");
                    double arg = in.nextDouble();
                    System.out.println("sin: " + calc.sin(arg));
                };break;
                case 16:{
                    System.out.println("Введите аргумент в радианах");
                    double arg = in.nextDouble();
                    System.out.println("cos: " + calc.cos(arg));
                };break;
                case 17:{
                    System.out.println("Введите аргумент в радианах");
                    double arg = in.nextDouble();
                    System.out.println("tan: " + calc.tan(arg));
                };break;
                case 18:{
                    System.out.println("Введите аргумент в радианах");
                    double arg = in.nextDouble();
                    System.out.println("ctg: " + calc.cotan(arg));
                };break;
                case 19:{
                    System.out.println("Введите значение");
                    double arg = in.nextDouble();
                    System.out.println("atan: " + calc.atan(arg));
                };break;
                case 20:{
                    System.out.println("Введите значение");
                    double arg = in.nextDouble();
                    System.out.println("acos: " + calc.acos(arg));
                };break;
                case 21:{
                    System.out.println("Введите значение");
                    double arg = in.nextDouble();
                    System.out.println("asin: " + calc.asin(arg));
                };break;

            }

        }

    }
}