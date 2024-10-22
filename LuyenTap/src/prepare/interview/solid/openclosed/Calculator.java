package prepare.interview.solid.openclosed;

public class Calculator {
    public int calculateNumber(int firstNumber, int secondNumber, Operation operation) {
        return operation.perform(firstNumber, secondNumber);
    }
}
