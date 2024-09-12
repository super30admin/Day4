// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In a rotated sorted array, we know that if we apply binary search, one half will be sorted and other half will be unsorted. 
// The lower element necessarily lies in the unsorted part.

class Solution {
    public int findMin(int[] nums) {
        //edge case check
        if(nums == null || nums.length == 0) {
            return -1;
        }
        // initialization
        int low = 0, high = nums.length-1;
        while(low < high) {
            int mid = low+ (high-low)/2;
            // condition to check the unsorted half of the rotated array
            if(nums[high] <= nums[mid]) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        return nums[low];
    }
}