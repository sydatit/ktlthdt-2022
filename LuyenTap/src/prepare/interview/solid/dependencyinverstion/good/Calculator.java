package prepare.interview.solid.dependencyinverstion.good;

public class Calculator {
    public int calculate(int x, int y, CalculationOperation operation) {
        return operation.calculate(x, y);
    }
}
