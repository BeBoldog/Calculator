import java.util.Scanner;

final class Helper {

    // Prevent instantiation of utility class
    private Helper() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    /**
     * Prompts the user until exactly two valid numbers are provided.
     */
    static Calculator.Operands getOperands(Scanner scanner) {
        while (true) {
            System.out.print("Give me 2 numbers divided by spaces: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\s+");

            if (parts.length != 2) {
                System.out.println("Error: You must enter exactly 2 numbers.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[1]);
                return new Calculator.Operands(num1, num2);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please try again.");
            }
        }
    }

    /**
     * Prompts the user until a single valid number is provided.
     */
    static double getOperand(Scanner scanner) {
        while (true) {
            System.out.print("Give me a number: ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please try again.");
            }
        }
    }
}