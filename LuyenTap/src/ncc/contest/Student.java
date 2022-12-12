package ncc.contest;

import java.util.*;

public class Student {
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
        long sum = map.values()
                .stream()
                .reduce(0L, (subTotal , element) -> subTotal + element*(element -1)/2);
        for (int i = 0; i < n; i++) {
            Long item = inputs.get(i);
            long res = 0;
            Long oldV = map.get(item);
            // tinh tong cac to hop chap 2 cua n
            res = sum - (oldV -1)*oldV/2;
            oldV--;
            res = res + (oldV -1)*oldV/2;
            System.out.println(res);
        }
    }
}
