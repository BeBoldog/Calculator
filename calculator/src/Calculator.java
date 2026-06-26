import java.util.Scanner;

public final class Calculator {

    record Operands(double num1, double num2) {}

    private static final Scanner scanner = new Scanner(System.in);

    // Prevent instantiation of the main calculator controller
    private Calculator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    /**
     * Main execution loop for the calculator.
     * Handles user input and triggers corresponding mathematical operations.
     */
    public static void on() {
        while (true) {
            System.out.print("""
                    
                    Choose the option:
                     1 - (+)      5 - (^)
                     2 - (-)      6 - (√)
                     3 - (*)      7 - (%)
                     4 - (/)      8 - Close
                    Option:\s""");

            int option;
            try {
                // Read the entire line and parse it to avoid scanner buffer issues
                option = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid menu number.");
                continue;
            }

            if (option == 8) {
                off();
                break;
            }

            try {
                processOption(option);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Routes the selected menu option to the correct method.
     */
    private static void processOption(int option) {
        // Handle two-operand operations
        if (option >= 1 && option <= 7 && option != 6) {
            Operands ops = Helper.getOperands(scanner);
            switch (option) {
                case 1 -> System.out.println("Result: " + Operation.add(ops.num1(), ops.num2()));
                case 2 -> System.out.println("Result: " + Operation.subtract(ops.num1(), ops.num2()));
                case 3 -> System.out.println("Result: " + Operation.multiply(ops.num1(), ops.num2()));
                case 4 -> System.out.println("Result: " + Operation.divide(ops.num1(), ops.num2()));
                case 5 -> System.out.println("Result: " + Operation.pow(ops.num1(), ops.num2()));
                case 7 -> System.out.println("Result: " + Operation.mod(ops.num1(), ops.num2()));
            }
        }
        // Handle single-operand operations
        else if (option == 6) {
            double op = Helper.getOperand(scanner);
            System.out.println("Result: " + Operation.sqrt(op));
        }
        else {
            System.out.println("Invalid number. Please select a valid option.");
        }
    }

    private static void off(){
        System.out.println("Closing calculator...");
    }
}