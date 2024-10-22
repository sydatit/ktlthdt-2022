package prepare.interview.oop.abstraction.car;

public class ManualCar implements Car{
    private String carType = "Manual";

    @Override
    public void turnOnCar() {
        System.out.println("Turning on manual car...");
    }

    @Override
    public void turnOffCar() {
        System.out.println("Turning off manual car...");
    }

    @Override
    public String getCarType() {
        return this.carType;
    }
}
