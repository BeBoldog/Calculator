import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private static final double DELTA = 0.0001;

    // ==========================================
    // 1. Math Operation Tests
    // ==========================================

    @Test
    void testAdd() {
        assertEquals(4.0, Operation.add(2, 2), DELTA);
        assertEquals(6.5, Operation.add(3.5, 3), DELTA);
    }

    @Test
    void testSubtract() {
        assertEquals(4.0, Operation.subtract(10, 6), DELTA);
        assertEquals(-1.5, Operation.subtract(6, 7.5), DELTA);
    }

    @Test
    void testMultiply() {
        assertEquals(8.0, Operation.multiply(2, 4), DELTA);
        assertEquals(0.0, Operation.multiply(5, 0), DELTA);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, Operation.divide(4, 2), DELTA);
        assertThrows(ArithmeticException.class, () -> Operation.divide(10, 0));
    }

    @Test
    void testPow() {
        assertEquals(9.0, Operation.pow(3, 2), DELTA);
        assertEquals(1.0, Operation.pow(5, 0), DELTA);
    }

    @Test
    void testSqrt() {
        assertEquals(3.0, Operation.sqrt(9), DELTA);
        assertThrows(ArithmeticException.class, () -> Operation.sqrt(-4));
    }

    @Test
    void testMod() {
        assertEquals(1.0, Operation.mod(10, 3), DELTA);
        assertThrows(ArithmeticException.class, () -> Operation.mod(5, 0));
    }

    // ==========================================
    // 2. Helper User Input Tests (Mocked Scanner)
    // ==========================================

    @Test
    void testGetOperand_ValidInput() {
        Scanner mockScanner = new Scanner("42.5\n");
        double result = Helper.getOperand(mockScanner);
        assertEquals(42.5, result, DELTA);
    }

    @Test
    void testGetOperand_InvalidThenValidInput() {
        // Simulates user typing text first, then correcting it with a valid number
        Scanner mockScanner = new Scanner("not_a_number\n12.3\n");
        double result = Helper.getOperand(mockScanner);
        assertEquals(12.3, result, DELTA);
    }

    @Test
    void testGetOperands_ValidInput() {
        Scanner mockScanner = new Scanner("10.5 20.5\n");
        Calculator.Operands ops = Helper.getOperands(mockScanner);
        assertEquals(10.5, ops.num1(), DELTA);
        assertEquals(20.5, ops.num2(), DELTA);
    }

    @Test
    void testGetOperands_WrongCountThenValidInput() {
        // Simulates entering 3 numbers, then 1 number, then exactly 2 numbers
        Scanner mockScanner = new Scanner("1 2 3\n9\n4.5 5.5\n");
        Calculator.Operands ops = Helper.getOperands(mockScanner);
        assertEquals(4.5, ops.num1(), DELTA);
        assertEquals(5.5, ops.num2(), DELTA);
    }

    @Test
    void testGetOperands_InvalidFormatThenValidInput() {
        // Simulates text input, then exactly 2 valid numbers
        Scanner mockScanner = new Scanner("bad input\n7.0 8.0\n");
        Calculator.Operands ops = Helper.getOperands(mockScanner);
        assertEquals(7.0, ops.num1(), DELTA);
        assertEquals(8.0, ops.num2(), DELTA);
    }

}