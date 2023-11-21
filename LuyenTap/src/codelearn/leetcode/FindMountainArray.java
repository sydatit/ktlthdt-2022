package codelearn.leetcode;

public class FindMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peek = findPeek(length, mountainArr);
        if (mountainArr.get(peek) == target)
            return peek;
        System.out.println("peek: " + peek);
        int findLeft = findInLeftSide(mountainArr, peek, target);
        int findRight = findInRightSide(mountainArr, peek, target);
        return findLeft != -1 ? findLeft : findRight;
    }

    private int findInRightSide(MountainArray mountainArr, int peek, int target) {
        int left = 0;
        int right = peek;
        while (left <= right) {
            int m = (right + left)/2;
            int valueM = mountainArr.get(m);
            if (valueM == target)
                return m;
            if (valueM > target)
                left = m + 1;
            else right = m - 1;
        }
        return -1;
    }

    private int findInLeftSide(MountainArray mountainArr, int peek, int target) {
        int left = 0;
        int right = peek;
        while (left <= right) {
            int m = (right + left)/2;
            int valueM = mountainArr.get(m);
            if (valueM == target)
                return m;
            if (valueM < target)
                left = m + 1;
            else right = m - 1;
        }
        return -1;
    }

    private int findPeek(int length, MountainArray mountainArr) {
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int m = (right + left) / 2;
            int valueM = mountainArr.get(m);
            int valueMPlus1 = mountainArr.get(m + 1);

            if (valueMPlus1 < valueM && valueM > mountainArr.get(m - 1)) {
                return m;
            }
            if (valueMPlus1 > valueM)
                left = m + 1;
            else right = m - 1;
        }
        return -1;
    }
}
interface MountainArray {
    public int get(int index);
    public int length();
 }