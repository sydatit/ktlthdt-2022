package prepare.interview.solid.dependencyinverstion.good;

public class AddOperation implements CalculationOperation{
    @Override
    public int calculate(int x, int y) {
        return x + y;
    }
}
