import java.util.Scanner;

public class Calculator {

    public record Operands(double num1, double num2){}
    static Scanner scanner = new Scanner(System.in);


    static double add(double num1, double num2){
        return num1 + num2;
    }

    static double subtract(double num1, double num2){
        return num1 - num2;
    }

    static double multiply(double num1, double num2){
        return num1 * num2;
    }

    static double divide(double num1, double num2){
        if (num2==0)
            throw new ArithmeticException("Math Error... Can not divide with 0.");
        return  num1 / num2;
    }

    static double pow(double base, double exponent){
        return Math.pow(base, exponent);
    }

    static double sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException("Math Error... Cannot take square root of a negative number.");
        }
        return Math.sqrt(num);
    }

    static double mod(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Math Error... Can not divide with 0.");
        }
        return num1 % num2;
    }


    public static void on(){

        System.out.print("Choose the option:\n 1 - (+)\n 2 - (-)\n 3 - (*)\n 4 - (/)\n 5 - (^)\n 6 - (√)\n7 - (%)\n 8 - Close\nOption: ");

        int option = scanner.nextInt();
        Operands operands;
        double operand;

        switch (option) {
            case 1:
                operands = getOperands();
                System.out.println("Result: " + add(operands.num1, operands.num2));
                break;
            case 2:
                operands = getOperands();
                System.out.println("Result: " + subtract(operands.num1, operands.num2));
                break;
            case 3:
                operands = getOperands();
                System.out.println("Result: " + multiply(operands.num1, operands.num2));
                break;
            case 4:
                operands = getOperands();
                System.out.println("Result: " + divide(operands.num1, operands.num2));
                break;
            case 5:
                operands = getOperands();
                System.out.println("Result: " + pow(operands.num1, operands.num2));
                break;
            case 6:
                operand = getOperand();
                System.out.println("Result: " + sqrt(operand));
                break;
            case 7:
                operands = getOperands();
                System.out.println("Result: " + mod(operands.num1, operands.num2));
                break;
            case 8:
                System.out.println("Closing calculator... ");
                return;
            default:
                System.out.println("Invalid number... ");
                on();
                return;
        }
        on();
    }



    static Operands getOperands(){

        try{
            System.out.print("Give me 2 numbers divided by spaces: ");
            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();

            return new Operands(num1, num2);
        } catch (Exception e) {
            System.out.println("Error occurred: "+e.getMessage());
            scanner.nextLine();
        }
        return getOperands();
    }

    static double getOperand(){

        System.out.print("Give me a number: ");
        try {
            return scanner.nextDouble();
        } catch (Exception e){
            System.out.println("Error occurred: "+e.getMessage());
            scanner.nextLine();
        }
        return getOperand();
    }
}

