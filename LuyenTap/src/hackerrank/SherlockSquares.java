package hackerrank;

public class SherlockSquares {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(24));
        System.out.println(Math.sqrt(50));
        System.out.println(squares(24, 50));
    }
    public static int squares(int a, int b) {
        // Write your code here
        int left = (int) Math.ceil(Math.sqrt(a));
        int right = (int) Math.floor(Math.sqrt(b));

        return right - left + 1;
    }
}
