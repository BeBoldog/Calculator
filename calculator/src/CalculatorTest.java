import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void add() {
        assertEquals(4,Calculator.add(2,2));
        assertEquals(6.5,Calculator.add(3.5,3));
        assertEquals(11,Calculator.add(4.3,6.7));
    }

    @Test
    public void subtract() {
        assertEquals(4, Calculator.subtract(10,6));
        assertEquals(-1.5, Calculator.subtract(6,7.5));
        assertEquals(3, Calculator.subtract(4,1));
    }

    @Test
    public void multiply() {
        assertEquals(8, Calculator.multiply(2,4));
        assertEquals(-9, Calculator.multiply(3,-3));
        assertEquals(5, Calculator.multiply(2.5,2));
    }

    @Test
    public void divide() {
        assertEquals(7, Calculator.divide(21,3));
        assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(10, 0);
        });
        assertEquals(2, Calculator.divide(4,2));
    }

    @Test
    public void pow() {
        assertEquals(9, Calculator.pow(3,2));
        assertEquals(16, Calculator.pow(4,2));
        assertEquals(27, Calculator.pow(3,3));
    }

    @Test
    public void sqrt() {
        assertEquals(2, Calculator.sqrt(4));
        assertThrows(ArithmeticException.class, () -> {
            Calculator.sqrt(-1);
        });
        assertEquals(0, Calculator.sqrt(0));
    }
}