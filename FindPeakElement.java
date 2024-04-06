// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, had to look into the explanation again

/*
Boundary conditions:
if mid =0 or nums[mid]> nums[mid+1] and nums[mid]>nums[mid-1] or mid = right extreme -> we found the peak

if nums[mid] is less than nums[mid+1] -> shift left to mid+1
 * 
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == right || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;

    }

}
