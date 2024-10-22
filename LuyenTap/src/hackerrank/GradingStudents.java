package hackerrank;

import java.util.Arrays;
import java.util.List;

public class GradingStudents {
    public static void main(String[] args) {
        System.out.println(gradingStudents(Arrays.asList(73, 67, 38, 33)));
    }
    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < 38) continue;
            int nextMultiple = findNextMultiple(grades.get(i));
            if (nextMultiple > 100) continue;
            if (nextMultiple - grades.get(i) < 3) grades.set(i, nextMultiple);
        }

        return grades;
    }

    private static int findNextMultiple(Integer integer) {
        int remaining = integer % 10;
        if (0 <= remaining && remaining < 5)
            return integer - remaining + 5;
        else
            return (10 -remaining) + integer;
    }
}
