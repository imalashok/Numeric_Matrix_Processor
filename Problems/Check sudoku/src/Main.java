import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isSudokuSolved = true;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 1; i <= n * n; i++) {
            uniqueNumbers.add(i);
        }

        int[][] sudoku = new int[n * n][n * n];

        for (int i = 0; i < n * n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(uniqueNumbers);
            for (int j = 0; j < n * n; j++) {
                sudoku[i][j] = scanner.nextInt();
                if (!temp.remove(Integer.valueOf(sudoku[i][j]))
                        || sudoku[i][j] > n * n || sudoku[i][j] < 1) { //checks horizontal lines
                    isSudokuSolved = false;
                }
            }
        }

        for (int i = 0; i < n * n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(uniqueNumbers);
            for (int j = 0; j < n * n; j++) {
                if (!temp.remove(Integer.valueOf(sudoku[j][i]))) { //checks vertical lines
                    isSudokuSolved = false;
                }
            }
        }

        for (int m = 0; m < n * n; m += n) {
            for (int k = 0; k < n * n; k += n) {
                ArrayList<Integer> temp = new ArrayList<>(uniqueNumbers);
                for (int i = m; i < n + m; i++) {
                    for (int j = k; j < n + k; j++) {
                        if (!temp.remove(Integer.valueOf(sudoku[i][j]))) { //checks all n * n squares
                            isSudokuSolved = false;
                        }
                    }
                }
            }
        }
        System.out.println(isSudokuSolved ? "YES" : "NO");
    }
}