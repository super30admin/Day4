// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to go over the recording to understand the logic.
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }

            int mid = low + (high - low)/2;
            if(( mid == 0 || nums[mid] < nums[mid - 1]) && nums[mid] < nums[mid + 1]){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return - 1;
    }
}