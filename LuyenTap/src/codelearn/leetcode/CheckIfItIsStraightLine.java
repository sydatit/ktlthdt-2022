package codelearn.leetcode;

public class CheckIfItIsStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {
                {1,2}
                ,{2,3}
                ,{3,4}
                ,{4,5}
                ,{5,6}
                ,{7,7}
        };
        System.out.println(new CheckIfItIsStraightLine().checkStraightLine(coordinates));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        boolean result = true;
        for (int i = 2; i < n; i++) {
            if( coordinates[0][1] == coordinates[1][1] ){
                if( coordinates[i][1] != coordinates[0][1] ){
                    result = false;
                    break;
                }
            }else if( coordinates[i][0] !=
                    ( coordinates[i][1] * (coordinates[1][0] - coordinates[0][0]) - (coordinates[0][1] * coordinates[1][0] - coordinates[0][0] * coordinates[1][1]) )
                            / (coordinates[1][1] - coordinates[0][1]) ){
                result = false;
                break;
            }
        }
        return result;
    }
}
/*
a = (y2 - y1) / (x2 - x1)
b = y1 - a * x1 = y1 - x1 *(y2 - y1)/(x2 - x1);
    = (y1*x2 - y1*x1 - x1*y2 + x1*y1) / (x2 - x1)
    = (y1*x2 - x1*y2) / (x2 - x1)
a * x + b = y
x = (y - b) / a
    = ( y -(y1*x2 - x1*y2) / (x2 - x1)) / ((y2 - y1) / (x2 - x1))
    = ( y*(x2 - x1) - (y1*x2 - x1*y2) ) / (y2 - y1)

    ----
    x = (y - b) / a
    x1 = (y1 - b) / a

    Ex
    (-3, 0)
    (1, 0)
    y = 0
 */
