public class Calculator {
    private Double firstOperand;
    private Double secondOperand;

    public Calculator(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public double addition() {
        return this.firstOperand + this.secondOperand;
    }

    public double subtraction() {
        return this.firstOperand - this.secondOperand;
    }

    public double multiplication() {
        return this.firstOperand * this.secondOperand;
    }

    public double division() throws ArithmeticException {
        if (secondOperand.equals(0.0)) {
            throw new ArithmeticException("Second operator cannot be zero");
        }

        return this.firstOperand / this.secondOperand;
    }

    public boolean isEquals() {
        return firstOperand.equals(this.secondOperand);
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }
}
