import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
    @CsvSource({"1,2,3", "0,2,2", "-1,2,1", "-1,-1,-2", "1.1,2,3.1", "0.0,2,2.0", "-1.1,2.2,1.1", "-1,-1,-2"})
    void addInt(ArgumentsAccessor argumentsAccessor) {
        double a = argumentsAccessor.getDouble(0);
        double b = argumentsAccessor.getDouble(1);
        double res = argumentsAccessor.getDouble(2);

        assertEquals(res, calculator.add(a,b));
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

    @ParameterizedTest
    @CsvSource({"5.01+2.000,7.01", "5.01-2.000,3.01", "5.01/2.000,2.505", "5.01*2.000,10.02", "12+-2,10.0"})
    public void shouldTakeUserInput(ArgumentsAccessor argumentsAccessor) {
        String input = argumentsAccessor.getString(0);
        String output = argumentsAccessor.getString(1);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(output, calculator.input());
    }

    @ParameterizedTest
    @CsvSource({"5.01+k23", "5.01-2.j0", "+23"})
    public void schoulThrowError(ArgumentsAccessor argumentsAccessor) {
        String input = argumentsAccessor.getString(0);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(IllegalArgumentException.class, ()->{
            System.setIn(in);
            calculator.input();
        });
    }

    @ParameterizedTest
    @CsvSource({"12--2", "12*-2"})
    public void schoulThrowErrorOutOfBounce(ArgumentsAccessor argumentsAccessor) {
        String input = argumentsAccessor.getString(0);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NumberFormatException.class, ()->{
            System.setIn(in);
            calculator.input();
        });
    }

}