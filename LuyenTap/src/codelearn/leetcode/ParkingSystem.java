package codelearn.leetcode;

public class ParkingSystem {
    int[] packingType = new int[3];

    public ParkingSystem(int big, int medium, int small) {
        packingType[0] = big;
        packingType[1] = medium;
        packingType[2] = small;
    }

    public boolean addCar(int carType) {
        if(packingType[carType - 1] == 0)
            return false;
        packingType[carType - 1]--;
        return true;
    }

    public static void main(String[] args) {
        ParkingSystem system = new ParkingSystem(1, 1, 0);
        System.out.println(system.addCar(1));
        System.out.println(system.addCar(2));
        System.out.println(system.addCar(3));
        System.out.println(system.addCar(1));
    }
}
