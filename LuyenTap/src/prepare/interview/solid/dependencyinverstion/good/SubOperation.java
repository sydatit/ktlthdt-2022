package prepare.interview.solid.dependencyinverstion.good;

public class SubOperation implements CalculationOperation{
    @Override
    public int calculate(int x, int y) {
        return x - y;
    }
}
