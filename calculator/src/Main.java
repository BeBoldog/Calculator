//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    System.out.println(Calculator.Add(1,4));
    System.out.println(Calculator.Add(5,4));

    System.out.println(Calculator.Subtract(5,4));
    System.out.println(Calculator.Subtract(2,4));

    System.out.println(Calculator.Multiply(2,4));
    System.out.println(Calculator.Multiply(5,4));

    System.out.println(Calculator.Divide(18,2));
    try{
        System.out.println(Calculator.Divide(18,0));
    } catch (Exception e) {
        System.out.println("Error occurred: "+e.getMessage());
    }
    System.out.println(Calculator.Divide(18,4));
}
