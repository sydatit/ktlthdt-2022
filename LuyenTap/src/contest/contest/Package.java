package contest.contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Package {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m;
        List<PairLong> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            PairLong pairLong = new PairLong(a, b);
            list.add(pairLong);
        }
        m = scanner.nextLong();
        list = list.stream()
                .sorted(Comparator.comparingLong(PairLong::getKey))
                .collect(Collectors.toList());
        PairLong temp = null;
        for (int i = 0; i < n; i++) {
            PairLong pair = list.get(i);
            if( temp != null){
                pair.setValue(temp.getValue() + pair.getValue());
            }
            temp = pair;
            if( m <= temp.getValue()){
                System.out.println(temp.getKey());
                break;
            }
        }
//        list.stream()
//                .forEach( p -> System.out.println("k: " + p.getKey() + "v: " + p.getValue()));
    }
}
class PairLong {
    private long key;
    private long value;
    public PairLong(long key, long value) {
        this.key = key;
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
