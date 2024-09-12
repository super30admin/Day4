/**
 * Sorted Array --> Good Candidate for Binary Search
 * 
 * Idea: Using Binary Search to find the minimum element in rotated sorted array.
 * 
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find
 * Minimum in Rotated Sorted Array. 
 * Memory Usage: 37.8 MB, less than 100.00% of
 * Java online submissions for Find Minimum in Rotated Sorted Array.
 */
public class FindMinRotatedSortedArray {
    /**
     * Find the minimum element in the given sorted rotated array.
     * 
     * @param nums given sorted rotated array
     * @return minimum element
     */
    public int findMin(int[] nums) {
        // base case checks
        // 1. array contains only single element
        // 2. array has not been rotated
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if element at mid is less than its previous
            // mid is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // if element at mid is greater than its next one
            // mid + 1 is the minimum element
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // if nums[0...mid] is sorted part, then update low else update high
            if (nums[0] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // this should never happen
        return -1;
    }
}