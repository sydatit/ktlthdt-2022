package laptrinhcoban;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex26_J02017 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(scanner.nextInt());

        }
        int i = 0;
        int size = list.size();
        while (i < size - 1) {
            if ((list.get(i) + list.get(i + 1)) % 2 == 0) {
                list.remove(i);
                list.remove(i);
                size = list.size();
                i = 0;
            }else i++;
        }
        System.out.println(list.size());
    }

}
