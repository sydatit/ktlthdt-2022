package com.dat;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        scanner.nextLine();
        while ( repeat --> 0){
            String firstStr = scanner.nextLine();
            String secondStr = scanner.nextLine();
            solve( firstStr, secondStr);
        }
    }
    private static void solve(String firstStr, String secondStr) {
        String[] firstArr = firstStr.split(" ");
        String[] secondArr = secondStr.split(" ");
        TreeSet<String> firstTreeSet = new TreeSet<>(Arrays.stream(firstArr).collect(Collectors.toSet()));
        TreeSet<String> secondTreeSet = new TreeSet<>(Arrays.stream(secondArr).collect(Collectors.toSet()));
        firstTreeSet.removeAll(secondTreeSet);
        firstTreeSet.stream().forEach( item -> System.out.printf(item + " "));
        System.out.println();
    }
}
