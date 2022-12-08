package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    public void setUp() {
        calculator = new AudiobookPriceCalculator();
        audiobook = new Audiobook("Odyseja kosmiczna", 100.0);
    }

    @Test
    public void test1() {
        Customer customer = new Customer("Kuba", Customer.LoyaltyLevel.STANDARD, true);
        double wynik = calculator.calculate(customer, audiobook);
        assertEquals(wynik, 0.0);
    }

    @Test
    public void test2() {
        Customer customer = new Customer("Kuba", Customer.LoyaltyLevel.SILVER, false);
        double wynik = calculator.calculate(customer, audiobook);
        assertEquals(wynik, 90.0);
    }

    @Test
    public void test3() {
        Customer customer = new Customer("Kuba", Customer.LoyaltyLevel.GOLD, false);
        double wynik = calculator.calculate(customer, audiobook);
        assertEquals(wynik, 80.0);
    }

    @Test
    public void test4() {
        Customer customer = new Customer("Kuba", Customer.LoyaltyLevel.STANDARD, false);
        double wynik = calculator.calculate(customer, audiobook);
        assertEquals(wynik, 100.0);
    }
}