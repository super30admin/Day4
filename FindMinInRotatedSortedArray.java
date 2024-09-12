// Time Complexity : O(log n) where n in size of input array nums
// Space Complexity : O(1) as we did not use any auxiliary space/data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {

        // null check
        if ( nums == null || nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low<=high) {

            if (nums[low] <= nums[high]) { // already sorted
                return nums[low];
            }

            int mid = low + (high-low) / 2;

            if ( ( mid == 0 || nums[mid] < nums[mid-1] ) &&
                    ( mid == nums.length -1 || nums[mid] < nums[mid+1]  ) )  {
                return nums[mid];
            }
            else if ( nums[low] <=  nums[mid]) { // array left sorted
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
