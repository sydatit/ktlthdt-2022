package codelearn.leetcode;

public class PeakIndexMountainArray {
    public static void main(String[] args) {
        PeakIndexMountainArray peakIndexMountainArray = new PeakIndexMountainArray();
        int[] arr = {0,1,5,2};
        System.out.println(peakIndexMountainArray.peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int res = 0;
        while (left < right){
            mid = (right + left) / 2;
            if( arr[mid] > arr[mid-1] && arr[mid] > arr[mid + 1]){
                res = mid;
                break;
            }

            if( mid - 1 >= 0){
                if (arr[mid] >= arr[mid - 1])
                    left = mid;
                else right = mid;
            } else if (mid + 1 < arr.length){
                if ( arr[mid] >= arr[mid + 1])
                    right = mid;
                else left = mid;
            }
        }
        return res;
    }
}
