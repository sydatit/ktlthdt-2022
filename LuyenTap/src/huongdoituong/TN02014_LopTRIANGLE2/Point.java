package huongdoituong.TN02014_LopTRIANGLE2;

public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double distance( Point secondPoint){
        double a = Math.pow( x - secondPoint.x, 2);
        double b = Math.pow(y - secondPoint.y, 2);
        return Math.sqrt(a + b);
    }
    public double distance( Point p1, Point p2){
        double a = Math.pow( p1.x - p2.x, 2);
        double b = Math.pow(p1.y - p2.y, 2);
        return Math.sqrt(a + b);
    }
    @Override
    public String toString() {
        return x + " " + y;
    }
}
