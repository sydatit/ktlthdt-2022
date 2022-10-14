package G_ChuSoNguyenTo;

import java.util.*;

public class ChuSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> strings =  Arrays.asList("2375", "2357", "2537", "2573", "2735", "2753", "3257", "3275", "3527", "3725", "5237", "5273", "5327", "5723", "7235", "7253", "7325", "7523");
        Queue<String> queue = new LinkedList<>(strings);
        ArrayList<String> result = new ArrayList<>();
        while (true){
            String head = queue.poll();
            if( head.length() <= n && head.charAt(head.length() - 1) != '2'){
                result.add(head);
            }else {
                if( head.length() > n) break;
            }
            queue.add( head + '2');
            queue.add( head + '3');
            queue.add( head + '5');
            queue.add( head + '7');
        }
        result.stream()
                .sorted((o1, o2) -> {
                    if( o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }else return o1.length() - o2.length();
                })
                .forEach(System.out::println);
    }
}
