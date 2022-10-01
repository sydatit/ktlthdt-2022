package com.dat;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5 {
    private static boolean[] marked;
    private static String[] resultName;
    private static String[] names;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        String endName = scanner.nextLine();
        solve( length, name, endName);
    }

    private static void solve(int length, String name, String endName) {
        marked = new boolean[length];
        resultName = new String[length];
        names = name.split(" ");
        int index = 0;
        for (int i = 0; i < length; i++) {
            if( names[i].equals(endName)){
                index = i;
                break;
            }
        }
        resultName[ length - 1] = endName;
        marked[index] = true;
        Try(0, length);
    }

    private static void Try(int i, int n) {
        for (int j = 0; j < n; j++) {
            if( !marked[j]){
                resultName[i] = names[j];
                marked[j] = true;
                if( i == n - 2){
                    // print all item
                    Arrays.stream(resultName).forEach( item -> System.out.printf(item + " "));
                    System.out.println();
                }else Try( i + 1, n);
                marked[j] = false;
            }
        }
    }

}
