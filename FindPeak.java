// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Logic- If mid isnt the peak, move in the direction of left if mid-1(left) is higher than mid+1(right) and vice versa.
//Graphically we can prove it.

class Solution {
    public int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) &&
               (mid == nums.length -1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if ( nums[mid] < nums[mid + 1]){ //right side is bigger.
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;

    }
}
