package prepare.interview.solid.openclosed;

public class BadCalculator {
    public int calculateNumber(int firstNumber, int secondNumber, String type) {
        int result = 0;
        switch (type) {
            case "sum":
                result = firstNumber + secondNumber;
                break;
            case "sub":
                result = firstNumber - secondNumber;
                break;
        }
        return result;
    }
}
