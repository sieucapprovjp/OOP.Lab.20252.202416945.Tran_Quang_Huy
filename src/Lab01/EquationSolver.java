// 2.2.6
package Lab01;
import java.util.Scanner;

public class EquationSolver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Solve a linear equation with one variable");
        System.out.println("2. Solve a system of first-degree equations with two variables");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveSystemOfLinearEquations(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
                break;
        }

        scanner.close();
    }

    public static void solveLinearEquation(Scanner scanner) {
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = -b / a;
            System.out.printf("The solution is x = %.2f%n", x);
        }
    }

    public static void solveSystemOfLinearEquations(Scanner scanner) {
        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter constant term b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter constant term b2: ");
        double b2 = scanner.nextDouble();

        if (a11 * a22 - a12 * a21 == 0) {
            if ((a11 * b2 - a21 * b1) == 0 && (a12 * b2 - a22 * b1) == 0) {
                System.out.println("Infinite solutions");
            } else {
                System.out.println("No solution");
            }
        } else {
            double x = (b1 * a22 - b2 * a12) / (a11 * a22 - a12 * a21);
            double y = (a11 * b2 - b1 * a21) / (a11 * a22 - a12 * a21);
            System.out.printf("The solution is x = %.2f and y = %.2f%n", x, y);
        }
    }
}
