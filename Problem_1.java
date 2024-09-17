// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        result[0] = leftSearch(nums, target);
        result[1] = rightSearch(nums, target);
        return result;
    }
    public int leftSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] < nums[mid] )){
                return mid;
            }
            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public int rightSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid] == target && (mid == nums.length-1 || nums[mid + 1] > nums[mid] )){
                return mid;
            }
            if(nums[mid] > target){
                high = mid - 1;
                
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
