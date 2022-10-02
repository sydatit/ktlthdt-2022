package huongdoituong.TN02014_LopTRIANGLE2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- >0){
            Triangle a = new Triangle(sc.nextLine());
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
/*
3
0 0 0 5 0 199
1 1 1 1 1 1
0 0 0 5 5 0
 */
