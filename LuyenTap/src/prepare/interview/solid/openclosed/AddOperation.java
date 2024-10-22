package prepare.interview.solid.openclosed;

public class AddOperation implements Operation{

    @Override
    public int perform(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
