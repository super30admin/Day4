// Time Complexity : O(log n)
// Space Complexity : O(1) => Constant space compleexity as we are not utizlizing additional space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : IndexOutOfBound as didn't add the condition if mid==0 (mid == low) or mid == nums.length -1 (mid == high)

/*
Approach: Compare the mid element to the left and right neighbout and if mid element is greater than both return mid. Otherwise
move in the direction of the the neighbour which is greater than the mid element
 */
class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 0 || nums == null)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //Prevents integer overflow

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}