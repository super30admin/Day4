// Problem 153: Find Minimum in Rotated Sorted Array
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] <= nums[high]){
                high = mid;
            }else if(nums[mid] > nums[high]){
                low = mid+1;
            }
        }
        return nums[low];
    }
}
