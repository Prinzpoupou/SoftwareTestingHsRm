import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void constructor() {
        Calculator calculator = null;
        calculator = new Calculator();
        assertNotNull(calculator);
        assertEquals(Calculator.class, calculator.getClass());
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "0,2,2", "-1,2,1", "-1,-1,-2"})
    void addInt(ArgumentsAccessor argumentsAccessor) {
        int a = argumentsAccessor.getInteger(0);
        int b = argumentsAccessor.getInteger(1);
        int res = argumentsAccessor.getInteger(2);

        assertEquals(res, calculator.add(a,b));
    }

    @ParameterizedTest
    @CsvSource({"1.1,2,3.1", "0.0,2,2.0", "-1.1,2.2,1.1", "-1,-1,-2"})
    void addDouble(ArgumentsAccessor argumentsAccessor) {
        double a = argumentsAccessor.getDouble(0);
        double b = argumentsAccessor.getDouble(1);
        double res = argumentsAccessor.getDouble(2);

        assertEquals(res, calculator.add(a,b));
    }

    @Test
    void addInt() {
        assertEquals(5, calculator.add(2, 3));
        int bla = calculator.add(2, 3);
        assertEquals(5, calculator.add(2, 3));
        assertEquals(5.111111111111111, calculator.add(2.111111111111111111111111111, 3));
    }

    @Test
    void subInt() {
        assertEquals(-1, calculator.sub(2, 3));
    }

    void subIntNeg() {
        assertEquals(-1, calculator.sub(2, 3));
    }

    @Test
    void multiInt() {
        assertEquals(6, calculator.multi(2, 3));
    }

    @Test
    void divInt() {
        assertEquals(2, calculator.div(2, 1));
        assertThrows(ArithmeticException.class, ()->{
            calculator.div(3,0);
        });
    }

    @Test
    void addDouble() {
        assertEquals(2.2+3.5, calculator.add(2.2, 3.5));
        assertEquals(5.111111111111111, calculator.add(2.111111111111111111111111111, 3));
    }

    @Test
    void subDouble() {
        assertEquals(-1, calculator.sub(2, 3));
    }

    @Test
    void multiDouble() {
        assertEquals(6, calculator.multi(2, 3));
    }

    @Test
    void divDouble() {
        assertEquals(2, calculator.div(2, 1));
        assertThrows(ArithmeticException.class, ()->{
            calculator.div(3,0);
        });
    }
}