final class Operation {

    // Prevent instantiation of utility class
    private Operation() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    static double add(double num1, double num2) {
        return num1 + num2;
    }

    static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Math Error: Cannot divide by zero.");
        }
        return num1 / num2;
    }

    static double pow(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    static double sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException("Math Error: Cannot take the square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    static double mod(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Math Error: Cannot divide by zero.");
        }
        return num1 % num2;
    }
}