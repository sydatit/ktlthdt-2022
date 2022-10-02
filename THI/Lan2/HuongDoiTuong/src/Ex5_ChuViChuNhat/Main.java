package Ex5_ChuViChuNhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectange rectange = new Rectange( Double.parseDouble(scanner.next()),Double.parseDouble(scanner.next()),
                scanner.next());
        if( rectange.isValid()){
            double area = rectange.findArea();
            double perimeter = rectange.findPerimeter();
            String areaStr =  ((area - (int)area) != 0 ? area + "" : (int)area + "");
            String perimeterStr =  ((perimeter - (int)perimeter) != 0 ? perimeter + "" : (int)perimeter + "");
            System.out.printf("%s %s %s", perimeterStr, areaStr, rectange.getColor());
        }else System.out.println("INVALID");
    }
}
