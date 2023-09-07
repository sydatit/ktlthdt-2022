package codelearn.leetcode;

class GFG {

    static int maxLen = 10;

    // Variable to store states of dp
    static int dp[] = new int[maxLen];

    // Variable to check
    // if a given state has been solved
    static boolean []visit = new boolean[maxLen];

    // Function to find the maximum sum subsequence
    // such that no two elements are adjacent
    static int maxSum(int arr[], int i,
                      int n, int k)
    {
        // Base case
        if (i >= n)
            return 0;

        // To check if a state has been solved
        if (visit[i])
            return dp[i];
        visit[i] = true;

        // Variable to store
        // prefix sum for sub-array
        // {i, j}
        int tot = 0;
        dp[i] = maxSum(arr, i + 1, n, k);

        // Required recurrence relation
        for (int j = i; j < (i + k) && (j < n); j++)
        {
            tot += arr[j];
            dp[i] = Math.max(dp[i], tot + maxSum(arr, j + 2, n, k));
        }
        // Returning the value
        return dp[i];
    }

    // Driver code
    public static void main (String[] args)
    {

        // Input array
        int arr[] = { -1, 2, -3, 4, 5 };

        int k = 2;

        int n = arr.length;

        System.out.println(maxSum(arr, 0, n, k));
    }
}
