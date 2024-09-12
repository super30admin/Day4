/**
 * Naive Approach: Using linear search to find an element that is greater than
 * its previous and next element.
 * 
 * Binary Search: Using Binary search to find a mid, and check whether it is the
 * peak or not. If it is the peak, return it otherwise if the element previous
 * to it, is larger, iteratively search on the left part of the array by
 * updating high, otherwise on the right side by updating low.
 * 
 * Space Complexity: O(1) Time Complexity: O(log n)
 * 
 * Leetcode Result:
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
 * Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Find Peak Element.
 */
public class FindPeakElement {
    /**
     * Returns the peak element from the input array
     * 
     * @param nums array to find peak element in.
     * @return peak element index
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return 0;
        }
        int low = 0, high = nums.length- 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
