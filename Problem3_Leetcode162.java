// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        // base case
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // start bonary search
        while(low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow

            // check if we have peak at mid
            // address the boundry condistions
            if((mid == low || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            else if(mid == n -1 || nums[mid + 1] > nums[mid]) {
                // In BS we need to move on either one of the direction. Here we can observe that if are standing at some point and if we move on higher side we will always defenitely find a peak on that side
                // Consider you are on range of mountains and standing at a point. It is most certein that if you move on side which is going up you will defenitely find a peak on the mountain on that side
                // That is the reason here we are moving on the side where adjaced value of mid is greater than mid
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        // Pointer will never reach here
        return -1;
    }
}