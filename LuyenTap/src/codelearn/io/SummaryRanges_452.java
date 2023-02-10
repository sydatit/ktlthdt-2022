package codelearn.io;

import java.util.*;

public class SummaryRanges_452 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SummaryRanges_452 ranges_452 = new SummaryRanges_452();
        while (true){
            System.out.println("---------------------");

            System.out.println("0. Exit");
            System.out.println("1. SummaryRanges");
            System.out.println("2. addNum");
            System.out.println("3. getIntervals");
            System.out.println("---------------------");
            int selection = scanner.nextInt();
            if( selection == 0)
                break;
            switch (selection){
                case 2:
                    int newV = scanner.nextInt();
                    ranges_452.addNum(newV);
                    break;
                case 3:
                    System.out.println(Arrays.deepToString(ranges_452.getIntervals()));
                    break;
            }
        }
    }
    private SortedSet<Integer> set;
    public SummaryRanges_452() {
        set = new TreeSet<>();
    }

    public void addNum(int value) {
        set.add(value);
    }

    public int[][] getIntervals() {
        int begin = set.first();
        int end = set.first();
        List<List<Integer>> lists = new ArrayList<>();

        for (Integer val: set.tailSet( begin + 1)) {
            if( val - end == 1){
                end = val;
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(begin);
                list.add(end);
                lists.add(list);
                begin = end = val;
            }
        }
        // add last interval
        List<Integer> list = new ArrayList<>(Arrays.asList( begin, end));
        lists.add(list);

        int[][] result = new int[lists.size()][2];
        for (int j = 0; j < result.length; j++) {
            List<Integer> listI = lists.get(j);
            result[j][0] = listI.get(0);
            result[j][1] = listI.get(1);
        }
        return result;
    }
}
