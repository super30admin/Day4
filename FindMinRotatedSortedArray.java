// Approach: Two violations of sortedness occur when an element is smaller than its preceding element or greater than its following
// element. By modifying the binary search return condition to check for these violations and reducing the search space based on the
// sorted side of the midpoint, this problem can be solved efficiently. It's similar to finding pivot index in a sorted rotated array.
// Returning the first element as minimum when the array is unrotated is an important edge case to consider.
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMinRotatedSortedArray {

    int findMin(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMinRotatedSortedArray fmrsa = new FindMinRotatedSortedArray();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
//        int[] arr = { 1, 2, 3, 4, 5 };
        int idx = fmrsa.findMin(arr);
        System.out.println("Minimum element is " + arr[idx] + " and it's found at index " + idx);
    }
}