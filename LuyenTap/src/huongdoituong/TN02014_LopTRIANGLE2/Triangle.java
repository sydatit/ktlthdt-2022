package huongdoituong.TN02014_LopTRIANGLE2;

import java.util.Scanner;

public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private double a_c;
    private double b_c;
    private double a_b;

    public Triangle(String newLine) {
        String[] doubleStr = newLine.split(" ");

        this.pointA = new Point( Double.parseDouble(doubleStr[0]), Double.parseDouble(doubleStr[1]));
        this.pointB = new Point( Double.parseDouble(doubleStr[2]), Double.parseDouble(doubleStr[3]));
        this.pointC = new Point( Double.parseDouble(doubleStr[4]), Double.parseDouble(doubleStr[5]));
        a_c = pointA.distance(pointC);
        b_c = pointB.distance(pointC);
        a_b = pointA.distance(pointB);
    }
    public boolean valid(){
        if( a_c + b_c <= a_b || a_c + a_b <= b_c || b_c + a_b <= a_c){
            return false;
        }
        return true;
    }
    public String getPerimeter(){
        double perimeter = a_b + a_c + b_c;
        return String.format("%.3f", Math.round(perimeter * 1000.0) / 1000.0);
    }
}
