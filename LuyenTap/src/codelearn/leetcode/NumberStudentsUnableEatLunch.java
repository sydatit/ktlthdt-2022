package codelearn.leetcode;

public class NumberStudentsUnableEatLunch {
    public static void main(String[] args) {
        NumberStudentsUnableEatLunch numberStudentsUnableEatLunch = new NumberStudentsUnableEatLunch();
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(numberStudentsUnableEatLunch.countStudents(students, sandwiches));
    }
    public int countStudents(int[] students, int[] sandwiches) {
        int[] preferences = new int[2];
        for (int student : students){
            preferences[0] += student == 0 ? 1 : 0;
            preferences[1] += student == 1 ? 1 : 0;
        }
        int index = -1;
        while (index + 1 < sandwiches.length && preferences[sandwiches[index + 1]] > 0){
            preferences[sandwiches[index + 1]]--;
            index++;
        }
        return sandwiches.length - 1 - index;
    }
}
