package com.dat;

import java.util.*;
import java.util.stream.Collectors;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while (repeat --> 0){
            int size = scanner.nextInt();
            ArrayList<Integer> listChan = new ArrayList<>();
            ArrayList<Integer> listLe = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int temp = scanner.nextInt();
                if( temp % 2 == 0) listChan.add(temp);
                else listLe.add(temp);
            }
            solveSort(listChan, listLe);
        }
    }

    private static void solveSort(ArrayList<Integer> listChan, ArrayList<Integer> listLe) {

        listChan.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach( integer -> System.out.printf(integer + " "));
        System.out.println();

        listLe.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(item -> System.out.printf(item + " "));
        System.out.println();
    }
}
