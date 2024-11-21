// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
class Solution {
    public int findMin(int[] nums) {
        //null
        if (nums.length == 0) return 0;
        int low = 0; int high = nums.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            //sorted situation
            if(nums[low] <= nums[high]) return nums[low];
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&
              (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){ //left is sorted
                low = mid + 1;
            }else{ //right
                high = mid - 1;
            }
        }
        return 100;
    }
}