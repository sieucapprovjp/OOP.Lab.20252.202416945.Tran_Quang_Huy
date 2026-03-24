package Lab01;
import java.util.Scanner;

public class CalculateTwoNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the first number
        System.out.print("Enter the first number: ");
        double num1;
        try {
            num1 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Prompt user for the second number
        System.out.print("Enter the second number: ");
        double num2;
        try {
            num2 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Calculate and display the sum, difference, product, and quotient
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        if (num2 == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            double quotient = num1 / num2;
            System.out.printf("Sum: %.2f\n", sum);
            System.out.printf("Difference: %.2f\n", difference);
            System.out.printf("Product: %.2f\n", product);
            System.out.printf("Quotient: %.2f\n", quotient);
        }

        scanner.close();
    }
}