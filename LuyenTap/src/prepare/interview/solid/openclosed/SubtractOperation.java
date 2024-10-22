package prepare.interview.solid.openclosed;

public class SubtractOperation implements Operation{

    @Override
    public int perform(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}
