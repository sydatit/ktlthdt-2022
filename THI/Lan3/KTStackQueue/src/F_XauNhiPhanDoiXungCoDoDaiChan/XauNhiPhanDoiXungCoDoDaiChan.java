package F_XauNhiPhanDoiXungCoDoDaiChan;

import java.util.*;

public class XauNhiPhanDoiXungCoDoDaiChan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        while ( repeat --> 0){
            int size = scanner.nextInt();
            solve(size);
        }
    }

    private static void solve(int size) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> res = new PriorityQueue<>();
        queue.add("00");
        queue.add("11");
        while (true){
            String firstEle = queue.poll();
            String secondEle = queue.poll();
            int length =  firstEle.length();
            if( length > size) break;
            else {
                res.add(firstEle);
                res.add(secondEle);
                queue.add( "0" + firstEle +  "0" );
                queue.add( "0" + secondEle +  "0" );
                queue.add( "1" + firstEle +  "1" );
                queue.add( "1" + secondEle +  "1" );
            }
        }
        res.stream()
                        .sorted(new Comparator<String>() {
                            @Override
                            public int compare(String o1, String o2) {
                                if( o1.length() == o2.length()){
                                    return o1.compareTo(o2);
                                }else return o1.length() - o2.length();
                            }
                        })
                                .forEach( item -> System.out.printf(item + " "));
        System.out.println();
    }
}
