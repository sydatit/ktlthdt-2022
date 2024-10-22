package prepare.interview.solid.dependencyinverstion.bad;

public class Calculator {
    public int calculate(int x, int y, String operation) {
        int result = 0;
        switch (operation) {
            case "add":
                AddOperation add = new AddOperation();
                result = add.add(x, y);
                break;
            case "sub":
                SubOperation sub = new SubOperation();
                result = sub.sub(x,y);
                break;
        }
        return result;
    }
}
