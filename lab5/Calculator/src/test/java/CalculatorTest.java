import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void getFirstOperand_PositiveAndNegativeValues_ReturnFirstOperand() {
        Calculator calculator = new Calculator(2.0, -90.0);
        double result = 2.0;
        double actual = calculator.getFirstOperand();
        assertEquals(result, actual, 0);
    }

    @Test
    public void getSecondOperand_PositiveAndNegativeValues_ReturnSecondOperand() {
        Calculator calculator = new Calculator(2.0, -90.0);
        double result = -90.0;
        double actual = calculator.getSecondOperand();
        assertEquals(result, actual, 0);
    }

    @Test
    public void addition_TwoPositiveNumbers_ReturnSumPositiveValue() {
        Calculator calculator = new Calculator(42.0, 108.0);
        double result = 150.0;
        double actual = calculator.addition();
        assertEquals(result, actual, 0);
    }

    @Test
    public void addition_TwoNegativeNumbers_ReturnSumNegativeValue() {
        Calculator calculator = new Calculator(-3.0, -19.0);
        double result = -22.0;
        double actual = calculator.addition();
        assertEquals(result, actual, 0);
    }

    @Test
    public void addition_PositiveAndNegativeNumbers_ReturnSumOfTwoNumbers() {
        Calculator calculator = new Calculator(8.0, -19.0);
        double result = -11.0;
        double actual = calculator.addition();
        assertEquals(result, actual, 0);
    }

    @Test
    public void addition_NormalAndZeroValues_ReturnSumNormalValue() {
        Calculator calculator = new Calculator(5.0, 0.0);
        double result = 5.0;
        double actual = calculator.addition();
        assertEquals(result, actual, 0);
    }

    @Test
    public void subtraction_FirstOperandMoreSecond_ReturnSubtractPositiveValue() {
        Calculator calculator = new Calculator(64.0, 5.0);
        double result = 59.0;
        double actual = calculator.subtraction();
        assertEquals(result, actual, 0);
    }

    @Test
    public void subtraction_FirstOperandLessSecond_ReturnSubtractNegativeValue() {
        Calculator calculator = new Calculator(-7.0, 42.0);
        double result = -49.0;
        double actual = calculator.subtraction();
        assertEquals(result, actual, 0);
    }

    @Test
    public void subtraction_FirstOperandIsZero_ReturnSubtractSecondValueWithOppositeSign() {
        Calculator calculator = new Calculator(0.0, -9.0);
        double result = 9.0;
        double actual = calculator.subtraction();
        assertEquals(result, actual, 0);
    }

    @Test
    public void subtraction_SecondOperandIsZero_ReturnSubtractFirstValue() {
        Calculator calculator = new Calculator(32.0, 0.0);
        double result = 32.0;
        double actual = calculator.subtraction();
        assertEquals(result, actual, 0);
    }

    @Test
    public void multiplication_TwoPositiveNumbers_ReturnMultiplicationPositiveValue() {
        Calculator calculator = new Calculator(5.0, 9.0);
        double result = 45.0;
        double actual = calculator.multiplication();
        assertEquals(result, actual, 0);
    }

    @Test
    public void multiplication_TwoNegativeNumbers_ReturnMultiplicationPositiveValue() {
        Calculator calculator = new Calculator(-10.0, -8.0);
        double result = 80.0;
        double actual = calculator.multiplication();
        assertEquals(result, actual, 0);
    }

    @Test
    public void multiplication_PositiveAndNegativeNumbers_ReturnMultiplicationNegativeValue() {
        Calculator calculator = new Calculator(6.0, -4.0);
        double result = -24.0;
        double actual = calculator.multiplication();
        assertEquals(result, actual, 0);
    }

    @Test
    public void multiplication_OneOperandIsZero_ReturnMultiplicationZeroValue() {
        Calculator calculator = new Calculator(70.0, 0.0);
        double result = 0.0;
        double actual = calculator.multiplication();
        assertEquals(result, actual, 0);
    }

    @Test
    public void division_TwoPositiveNumbers_ReturnDivisionPositiveValue() {
        Calculator calculator = new Calculator(34.0, 2.0);
        double result = 17.0;
        double actual = calculator.division();
        assertEquals(result, actual, 0);
    }

    @Test
    public void division_TwoNegativeNumbers_ReturnDivisionPositiveValue() {
        Calculator calculator = new Calculator(-21.0, -7.0);
        double result = 3.0;
        double actual = calculator.division();
        assertEquals(result, actual, 0);
    }

    @Test
    public void division_PositiveAndNegativeNumbers_ReturnDivisionNegativeValue() {
        Calculator calculator = new Calculator(56.0, -8.0);
        double result = -7.0;
        double actual = calculator.division();
        assertEquals(result, actual, 0);
    }

    @Test
    public void division_FirstOperandIsZero_ReturnDivisionZeroValue() {
        Calculator calculator = new Calculator(0.0, 3.0);
        double result = 0.0;
        double actual = calculator.division();
        assertEquals(result, actual, 0);
    }

    @Test(expected = ArithmeticException.class)
    public void division_SecondOperandIsZero_ReturnArithmeticException() throws ArithmeticException {
        Calculator calculator = new Calculator(41.0, 0.0);
        calculator.division();
    }

    @Test
    public void isEquals_TwoEqualPositiveNumbers_ReturnTrueResult() {
        Calculator calculator = new Calculator(12.0, 12.0);
        assertTrue(calculator.isEquals());
    }

    @Test
    public void isEquals_TwoEqualNegativeNumbers_ReturnTrueResult() {
        Calculator calculator = new Calculator(-29.0, -29.0);
        assertTrue(calculator.isEquals());
    }

    @Test
    public void isEquals_TwoVariousPositiveNumbers_ReturnFalseResult() {
        Calculator calculator = new Calculator(89.0, 76.0);
        assertFalse(calculator.isEquals());
    }

    @Test
    public void isEquals_TwoVariousNegativeNumbers_ReturnFalseResult() {
        Calculator calculator = new Calculator(-6.0, -43.0);
        assertFalse(calculator.isEquals());
    }

    @Test
    public void isEquals_TwoEqualNegativeAndPositiveNumbers_ReturnFalseResult() {
        Calculator calculator = new Calculator(-6.0, 6.0);
        assertFalse(calculator.isEquals());
    }

    @Test
    public void isEquals_TwoVariousNegativeAndPositiveNumbers_ReturnFalseResult() {
        Calculator calculator = new Calculator(-6.0, 37.0);
        assertFalse(calculator.isEquals());
    }
}