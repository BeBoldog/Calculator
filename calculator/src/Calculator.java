public class Calculator {

    static int Add(int num1, int num2){
        return num1 + num2;
    }

    static int Subtract(int num1, int num2){
        return num1 - num2;
    }

    static int Multiply(int num1, int num2){
        return num1 * num2;
    }

    static  double Divide(double num1, double num2){
        if (num2==0)
            throw new ArithmeticException("Math Error... Can not divide with 0.");
        return  num1 / num2;
    }
}
