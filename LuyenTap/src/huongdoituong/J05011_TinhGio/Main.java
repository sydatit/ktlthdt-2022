package huongdoituong.J05011_TinhGio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long repeat = Long.parseLong(scanner.nextLine());
        List<GameThu> list = new ArrayList<>();
        while (repeat-->0){
            GameThu gameThu = new GameThu(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            list.add(gameThu);
        }
        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
/*
3
01T
Nguyen Van An
09:00
10:30
06T
Hoang Van Nam
15:30
18:00
02I
Tran Hoa Binh
09:05
10:00
 */