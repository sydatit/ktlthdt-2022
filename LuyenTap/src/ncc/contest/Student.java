package ncc.contest;

import java.math.BigInteger;
import java.util.*;

public class Student {
    static ArrayList<BigInteger> numbers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> inputs = new ArrayList<>();
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long temp = scanner.nextInt();
            inputs.add(temp);
            if( map.containsKey(temp)){
                Long oldV = map.get(temp);
                map.put(temp, oldV + 1);
            }else map.put(temp, 1L);
        }
        for (int i = 0; i < n; i++) {
            Long item = inputs.get(i);
            long res = 0;
            Long oldV = map.get(item);
            map.put(item, oldV - 1);
            // tinh tong cac to hop chap 2 cua n
            res = map.values()
                        .stream()
                        .reduce(0L, (subTotal , element) -> subTotal + element*(element -1)/2);
            System.out.println(res);
            map.put(item, oldV);
        }
    }
}
