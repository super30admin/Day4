// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }
            if(nums[mid] < nums[high]) {
                high = mid;
            }
        } return nums[low];
    }
}
