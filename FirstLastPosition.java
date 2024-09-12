/**
 * As the given array is sorted, its a good candidate for applying Binary
 * Search.
 * 
 * Brute Force: Linearly search for the first and last occurence of the target
 * element. Space: Constant, Time: O(n)
 * 
 * Better Brute Force: Find the target in array using binary search, then linear
 * walk backwards to get first occurence and linear walk forwards to get last
 * occurence Space: Constant, Time: O(n)
 * 
 * Explanation: The modified version of binary search that I have used here
 * returns the rightmost index after which we can insert the target element.
 * Making 2 calls to this routine, I obtain the first and last occurence of the
 * target. Space: Constant Time: O(log n)
 * 
 * Leetcode Results: Runtime: 0 ms, faster than 100.00% of Java online
 * submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 43.1 MB, less than 97.87% of Java online submissions for Find
 * First and Last Position of Element in Sorted Array.
 */
class FirstLastPosition {
    /**
     * To determine the first and last position of target element in the array
     * 
     * @param nums   array of integers
     * @param target element whose first and last occurence is to be determined
     * @return first and last occurence index of element, {-1, -1} if not found.
     */
    public int[] searchRange(int[] nums, int target) {
        // base case checks
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int first, last;
        first = insertIndex(nums, target - 1);
        last = insertIndex(nums, target);
        // if both are same, it means the target element does not exist in array
        if (first == last) {
            return new int[] { -1, -1 };
        }
        return new int[] { first + 1, last };
    }

    /**
     * Computes the right most index after which the target elemetn can be inserted
     * such that the array still remains sorted.
     * 
     * If the target element is less than the smallest element, it returns -1 which
     * implies, target can be inserted after index `-1` i.e. at index 0
     * 
     * If the target element is greater than the largest element, it returns the
     * arr.length - 1 which implies, target can be inserted after the `size-1`
     * 
     * @param arr    sorted array of integers
     * @param target element to be inserted
     * @return index i such that target can be inserted in sorted order
     */
    private int insertIndex(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (target < arr[0]) {
            return -1;
        }
        if (target >= arr[arr.length - 1]) {
            return arr.length - 1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target && arr[mid + 1] > target) {
                // index found
                return mid;
            }
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}