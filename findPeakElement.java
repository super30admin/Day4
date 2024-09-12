// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            //check peak by comparing the neighbors
            //if you already reached the edge then you already reached peak so mid == 0 needed
            if((mid == 0 || nums[mid] > nums[mid - 1]) && 
               (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            //move left if left neighbor is bigger
            else if(mid > 0 && nums[mid] < nums[mid - 1]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return - 1;
    }
}
