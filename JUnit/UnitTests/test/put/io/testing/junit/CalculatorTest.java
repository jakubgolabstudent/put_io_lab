package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int x = 5;
        int y = 10;
        int res;
        res = calculator.add(x, y);
        assertEquals(15, res);
    }


    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int wynik = calculator.multiply(2, 5);
        assertEquals(10, wynik);
    }

    @Test
    public void testAddPositiveNumbers() throws IllegalArgumentException {
        int x = -5;
        int y = 2;
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {calculator.addPositiveNumbers(x, y);});
    }
}