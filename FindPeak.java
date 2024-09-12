// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// To find one of the peaks, we need to check if elements on either side of a chosen point is lesser than the element itself. 
// We can leverage the power of binary search to move the search towards the side having larger value in the case when chosen element 
// is lesser.


class Solution {
    public int findPeakElement(int[] nums) {
        //edge case check
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low+(high-low)/2;
            // peak condition : if mid element is greater than the elements on either side
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            // select the side which promises higher value
            if(mid < nums.length-1 && nums[mid] < nums[mid+1]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}