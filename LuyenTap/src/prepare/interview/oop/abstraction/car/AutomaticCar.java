package prepare.interview.oop.abstraction.car;

public class AutomaticCar implements Car{
    private String carType = "automatic";
    @Override
    public void turnOnCar() {
        System.out.println("Turning on automatic car...");
    }

    @Override
    public void turnOffCar() {
        System.out.println("Turning off automatic car...");
    }

    @Override
    public String getCarType() {
        return carType;
    }
}
