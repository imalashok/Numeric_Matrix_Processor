package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int aRow;
        int aColumn;
        int bRow;
        int bColumn;
        double[][] matrixA;
        double[][] matrixB;
        double[][] resultMatrix;
        double matrixDeterminant;


        while (true) {
            Scanner scanner = new Scanner(System.in);
            showMainMenu();
            switch (scanner.nextLine()) {
                case "1":
                    System.out.print("Enter size of first matrix: ");
                    aRow = scanner.nextInt();
                    aColumn = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = fillMatrix(aRow, aColumn);
                    System.out.print("Enter size of second matrix: ");
                    bRow = scanner.nextInt();
                    bColumn = scanner.nextInt();
                    System.out.println("Enter second matrix: ");
                    matrixB = fillMatrix(bRow, bColumn);

                    if (aRow == bRow && aColumn == bColumn) {
                        resultMatrix = calculateSumOfTwoMatrices(matrixA, matrixB);
                        System.out.println("The result is:");
                        printMatrix(resultMatrix);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "2":
                    System.out.print("Enter matrix size: ");
                    aRow = scanner.nextInt();
                    aColumn = scanner.nextInt();
                    System.out.println("Enter matrix: ");
                    matrixA = fillMatrix(aRow, aColumn);
                    System.out.print("Enter constant: ");
                    int constant = scanner.nextInt();
                    resultMatrix = multiplyMatrixByNumber(matrixA, constant);
                    System.out.println("The multiplication result is:");
                    printMatrix(resultMatrix);
                    break;
                case "3":
                    System.out.print("Enter size of first matrix: ");
                    aRow = scanner.nextInt();
                    aColumn = scanner.nextInt();
                    System.out.println("Enter first matrix: ");
                    matrixA = fillMatrix(aRow, aColumn);
                    System.out.print("Enter size of second matrix: ");
                    bRow = scanner.nextInt();
                    bColumn = scanner.nextInt();
                    System.out.println("Enter second matrix: ");
                    matrixB = fillMatrix(bRow, bColumn);

                    if (aColumn == bRow) {
                        resultMatrix = calculateMultiplicationOfTwoMatrices(matrixA, matrixB);
                        System.out.println("The multiplication result is:");
                        printMatrix(resultMatrix);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "4":
                    showMatrixTranspositionMenu();
                    String transpositionType = scanner.nextLine();
                    switch (transpositionType) {
                        case "1":
                        case "2":
                        case "3":
                        case "4":
                            System.out.print("Enter matrix size: ");
                            aRow = scanner.nextInt();
                            aColumn = scanner.nextInt();
                            System.out.println("Enter matrix: ");
                            matrixA = fillMatrix(aRow, aColumn);
                            resultMatrix = transposeMatrix(matrixA, transpositionType);
                            System.out.println("The result is:");
                            printMatrix(resultMatrix);
                            break;
                        default:
                            System.out.println("Wrong transposition type");
                            break;
                    }
                    break;
                case "5":
                    System.out.print("Enter matrix size: ");
                    aRow = scanner.nextInt();
                    aColumn = scanner.nextInt();
                    System.out.println("Enter matrix: ");
                    matrixA = fillMatrix(aRow, aColumn);
                    if (aRow == aColumn) {
                        matrixDeterminant = calculateMatrixDeterminant(matrixA);
                        System.out.println("The result is:");
                        System.out.println(matrixDeterminant);
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "6":
                    System.out.print("Enter matrix size: ");
                    aRow = scanner.nextInt();
                    aColumn = scanner.nextInt();
                    System.out.println("Enter matrix: ");
                    matrixA = fillMatrix(aRow, aColumn);
                    if (aRow == aColumn) {
                        matrixDeterminant = calculateMatrixDeterminant(matrixA);
                        if (matrixDeterminant != 0) {
                            resultMatrix = transposeMatrix(calculateMatrixOfCofactors(calculateMatrixOfMinors(matrixA)), "1");
                            resultMatrix = multiplyMatrixByNumber(resultMatrix, 1 / matrixDeterminant);
                            System.out.println("The result is:");
                            printMatrix(resultMatrix);
                        } else {
                            System.out.println("Determinant of the matrix equals zero.");
                        }
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong menu number.");
                    break;
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\n1. Add matrices");
        System.out.println("2. Multiply matrix to a constant");
        System.out.println("3. Multiply matrices");
        System.out.println("4. Transpose matrix");
        System.out.println("5. Calculate a determinant");
        System.out.println("6. Inverse matrix");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    public static void showMatrixTranspositionMenu() {
        System.out.println("\n1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: ");
    }

    public static double[][] calculateSumOfTwoMatrices(double[][] matrixA, double[][]matrixB) {
        double[][] matrixSum = new double[matrixA.length][matrixA[0].length];

        for (int i = 0; i < matrixSum.length; i++) {
            for (int j = 0; j < matrixSum[0].length; j++) {
                matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixSum;
    }

    public static double[][] multiplyMatrixByNumber(double[][] matrix, double number) {
        double[][] matrixMultipliedByNumber = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixMultipliedByNumber[i][j] = matrix[i][j] * number;
            }
        }
        return matrixMultipliedByNumber;
    }

    public static double[][] calculateMultiplicationOfTwoMatrices(double[][] matrixA, double[][] matrixB) {
        double[][] matrixMultiplication = new double[matrixA.length][matrixB[0].length];

        for (int i = 0; i < matrixMultiplication.length; i++) {
            for (int j = 0; j < matrixMultiplication[0].length; j++) {
                for (int k = 0, m = 0; k < matrixA[0].length; k++, m++) {
                    matrixMultiplication[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixMultiplication;
    }

    public static double[][] transposeMatrix(double[][] matrix, String transpositionType) {
        double[][] matrixTransposed = new double[matrix.length][matrix[0].length];

        switch (transpositionType) {
            case "1":
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrixTransposed[j][i] = matrix[i][j];
                    }
                }
                break;
            case "2":
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrixTransposed[matrix.length - 1 - j][matrix.length - 1 - i] = matrix[i][j];
                    }
                }
                break;
            case "3":
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrixTransposed[i][matrix.length - 1 - j] = matrix[i][j];
                    }
                }
                break;
            case "4":
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrixTransposed[matrix.length - 1 - i][j] = matrix[i][j];
                    }
                }
                break;
            default:
                break;
        }
        return matrixTransposed;
    }

    public static double calculateMatrixDeterminant(double[][] matrix) {
        double matrixDeterminant = 0;

        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrixDeterminant += Math.pow(-1, i + 2) * matrix[0][i] * calculateMatrixDeterminant(findMinorMatrix(matrix, 0, i));
        }
        return matrixDeterminant;
    }

    public static double[][] findMinorMatrix(double[][] matrix, int row, int column) {
        double[][] minorMatrix = new double[matrix.length - 1][matrix[0].length - 1];
        int n = 0;
        int m = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != row && j != column) {
                    minorMatrix[n][m] = matrix[i][j];
                    m++;
                    if (m == matrix[0].length - 1) {
                        m = 0;
                        n++;
                    }
                }
            }
        }
        return minorMatrix;
    }

    public static double[][] calculateMatrixOfMinors(double[][] matrix) {
        double[][] matrixOfMinors = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixOfMinors[i][j] = calculateMatrixDeterminant(findMinorMatrix(matrix, i, j));
            }
        }
        return matrixOfMinors;
    }

    public static double[][] calculateMatrixOfCofactors(double[][] matrix) {
        double[][] matrixOfCofactors = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixOfCofactors[i][j] = Math.pow(-1, i + 1 + j + 1) * matrix[i][j];
            }
        }
        return matrixOfCofactors;
    }

    public static double[][] fillMatrix(int n, int m) {
        Scanner scanner = new Scanner(System.in);
        double[][] matrix = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%.2f ", ints[j]);
            }
            System.out.println();
        }
    }
}