package org.example;

import java.net.SocketTimeoutException;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.RombergIntegrator;

public class Calculator {
    public double sum(double first, double second){
        return first+second;
    }

    public double sub(double first, double second){
        return first-second;
    }

    public double del(double first, double second){
        if (second != 0 ) return first/second;
        else {
            System.out.println("Попытка деления на 0");
            return Double.POSITIVE_INFINITY;
        }
    }

    public double mul(double first, double second){
        return first*second;
    }

    public double degree(double x, double y){
        return Math.pow(x, y);
    }

    public double[] equation(double a, double b, double c){
        if (a==0){
            if (b==0){
                if (c == 0){
                    System.out.println("Бесконечное число решений");
                    return new double[]{Double.POSITIVE_INFINITY};
                }
                else {
                    System.out.println("Решений нет");
                    return new double[]{0};
                }
            }
            else {
                double ans = -c / b;
                return new double[]{ans};
            }
        }
        else {
            double[] ans = new double[2];
            double D = b * b - 4 * a * c;
            if (D >= 0) {
                ans[0] = (b - Math.sqrt(D)) / a;
                ans[1] = (b + Math.sqrt(D)) / a;
                return ans;
            } else {
                System.out.println("Отрицательный дискреминант");
                return new double[]{0};
            }
        }

    }

    public double[][] transposeMatrix(double[][] matrix){
        double[][] newMatrix = new double[matrix[0].length][matrix.length];
        for (int i =0; i < matrix.length; i++){
            for (int j =0; j < matrix[0].length; j++){
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }

    private static double[][] createSubmatrix(double[][] matrix, int excludingRow, int excludingColumn) {
        int n = matrix.length;
        double[][] submatrix = new double[n - 1][n - 1];
        int rowIndex = 0;
        int columnIndex;

        for (int i = 0; i < n; i++) {
            if (i == excludingRow) {
                continue;
            }

            columnIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == excludingColumn) {
                    continue;
                }

                submatrix[rowIndex][columnIndex] = matrix[i][j];
                columnIndex++;
            }

            rowIndex++;
        }

        return submatrix;
    }
    public double determinantMatrix(double[][] matrix){
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else {
            double determinant = 0;
            int sign = 1;

            for (int column = 0; column < n; column++) {
                double[][] submatrix = createSubmatrix(matrix, 0, column);
                determinant += sign * matrix[0][column] * determinantMatrix(submatrix);
                sign *= -1;
            }

            return determinant;
        }

    }

    private static double[][] createAugmentedMatrix(double[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        double[][] augmentedMatrix = new double[n][2 * n];

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                augmentedMatrix[row][column] = matrix[row][column];
            }
            augmentedMatrix[row][row + n] = 1;
        }

        return augmentedMatrix;
    }

    public double[][] inverseMatrix(double[][] matrix){
        int n = matrix.length;
        double[][] augmentedMatrix = createAugmentedMatrix(matrix);
        double[][] inverseMatrix = new double[n][n];

        for (int pivot = 0; pivot < n; pivot++) {
            double pivotValue = augmentedMatrix[pivot][pivot];

            for (int column = 0; column < 2 * n; column++) {
                augmentedMatrix[pivot][column] /= pivotValue;
            }

            for (int row = 0; row < n; row++) {
                if (row == pivot) {
                    continue;
                }

                double rowFactor = augmentedMatrix[row][pivot];

                for (int column = 0; column < 2 * n; column++) {
                    augmentedMatrix[row][column] -= rowFactor * augmentedMatrix[pivot][column];
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                inverseMatrix[row][column] = augmentedMatrix[row][column + n];
            }
        }

        return inverseMatrix;
    }


    public double[][] sumMatrix(double[][] matrix1, double[][] matrix2){
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
            double[][] newMatrix = new double[matrix1[0].length][matrix1.length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            return newMatrix;
        }
        return new double[][] {{0}};
    }

    public double[][] subMatrix(double[][] matrix1, double[][] matrix2){
        if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
        double[][] newMatrix = new double[matrix1[0].length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                newMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return newMatrix;
    }
        return new double[][] {{0}};
    }

    public double[][] mulMatrix(double[][] matrix1, double[][] matrix2){
        if (matrix1[0].length != matrix2.length) {
            System.err.println("Эти матрицы нельзя перемножить");
            return null;
        }
        double[][] matrixM = new double[matrix1.length][matrix2[0].length];
        for (var i = 0; i < matrixM.length; i++) {
            for (var j = 0; j < matrixM[0].length; j++) {
                matrixM[i][j] = 0;
                for (var k = 0; k < matrix1[0].length; k++) {
                    matrixM[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixM;
    }

    public double[][] mulMatrixWithNum(double[][] matrix, double number){
        double[][] newMatrix = new double[matrix.length][matrix[0].length];
        for (int i =0; i < matrix.length; i++){
            for (int j =0; j < matrix[0].length; j++){
                newMatrix[i][j] = matrix[j][i] * number;
            }
        }
        return newMatrix;
    }

    public double integral( String integralExpression, double lowerBound, double upperBound){
        UnivariateFunction function = (x) -> {
            // Вычисляем значение функции для каждой точки x
            double result = 0.0;
            try {
                result = Double.parseDouble(integralExpression.replace("x", String.valueOf(x)));
            } catch (NumberFormatException e) {
                // Обработка ошибки при некорректном пользовательском вводе
                System.out.println("Некорректный ввод интеграла.");

            }
            return result;
        };

        // Используем объект RombergIntegrator из Apache Commons Math для вычисления интеграла
        RombergIntegrator integrator = new RombergIntegrator();
        double integral = integrator.integrate(1000, function, lowerBound, upperBound);
        return integral;
    }

    double sin(double arg){
        return Math.sin(arg);
    }

    double cos(double arg){
        return Math.cos(arg);
    }

    double tan(double arg){
        return Math.tan(arg);
    }

    double cotan(double arg){
        return 1/Math.tan(arg);
    }

    double atan(double arg){
        return Math.atan(arg);
    }

}
