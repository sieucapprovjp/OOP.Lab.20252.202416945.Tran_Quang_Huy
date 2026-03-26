// Ex 6.6
// Write a Java program to add two matrices of the same size.
package Lab01;
import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int column = scanner.nextInt();

        int[][] matrix1 = new int[row][column];
        int[][] matrix2 = new int[row][column];
        int[][] sum = new int[row][column];

        System.out.println("Enter the first matrix:");
        fillMatrix(scanner,matrix1,row,column);
        System.out.println("Enter the second matrix:");
        fillMatrix(scanner,matrix2,row,column);

        for (int i=0;i<row;i++) {
            for (int j =0;j<column;j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("Result:");
        displayMatrix(sum,row,column);
        scanner.close();
    }
    public static void fillMatrix(Scanner sc, int[][] matrix, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("Element [%d][%d]: ", i, j);
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static void displayMatrix(int[][] matrix, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}