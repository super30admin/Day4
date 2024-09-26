// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binary2;

public class MinRotatedSortedArray {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[high] > nums[low]) {
            return nums[0];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
