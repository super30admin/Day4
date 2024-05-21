// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// logic: Using Binary search check if middle number (mid) is greater than adjacent numbers or not.
// If the middle number is greater than return the position of the mid. If mid-1 > mid and mid+1 < mid then move the high to mid -1 position
// if mid+1 > mid and mid -1 < mid then move low to mid+1 position.


class Solution {
    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2; // prevent integer overflow
            if((mid == low || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}