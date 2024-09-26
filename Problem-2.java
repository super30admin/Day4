// Time Complexity : O(log N)  {Binary Search}
// Space Complexity : O(log N)  {as recursion is used}
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Here we go with finding minimum number using binary search recursively.
// Performing the search operation on the rotated part, because of the fact that sorted part will never have minimum value
class Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        return findMinimum(nums, low, high);
    }

    public int findMinimum(int[] n, int low, int high) {
        if (high == low) {
            return n[low];
        }

        int mid = (high + low) / 2;

        if (n[mid] > n[high]) {
            // search in right side
            return findMinimum(n, mid + 1, high);
        } else {
            // search in left side
            return findMinimum(n, low, mid);
        }
    }
}