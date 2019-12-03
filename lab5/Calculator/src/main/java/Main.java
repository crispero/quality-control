public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(4.0, 9.0);
        System.out.println("Первый оператор: " + calculator.getFirstOperand());
        System.out.println("Вычитание: " + calculator.getSecondOperand());
        System.out.println("Сложение: " + calculator.addition());
        System.out.println("Вычитание: " + calculator.subtraction());
        System.out.println("Умножение: " + calculator.multiplication());
        System.out.println("Деление: " + calculator.division());
        System.out.println("Равенство: " + calculator.isEquals());
    }
}
