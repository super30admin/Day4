// Approach: A simple tweak to the binary search algorithm is required here. When the target is found at a position, instead of
// returning that index, collect the index and continue narrowing the search space by moving left or right, depending on whether
// we are trying to find the start or end position. This process continues until we reach the first or last occurrence of the target.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class TargetPositionRangeInSortedArray {

    int findStart(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                idx = mid;
                high = mid - 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    int findEnd(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                idx = mid;
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        TargetPositionRangeInSortedArray tprisa = new TargetPositionRangeInSortedArray();
        int[] arr = { 1, 1, 2, 2, 2, 4, 5, 5, 8, 9, 9, 9 };
        int target = 2;
        int left = tprisa.findStart(arr, target);
        if (left == -1) {
            System.out.println("Element not found..");
        }
        int right = tprisa.findEnd(arr, target);
        System.out.println("Element " + target + " found between indices [ " + left + " , " + right + " ]");
    }
}