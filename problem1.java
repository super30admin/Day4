// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findPosition(nums, target, true), findPosition(nums, target, false)};
    }
    
    private int findPosition(int[] nums, int target, boolean isFirst){
        
        int low = 0, high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low) /2;
            
            if(nums[mid] == target){
                if(isFirst){
                    if(mid == low || nums[mid-1] != target){
                        return mid;
                    }
                    
                    high = mid-1;
                    
                } else {
                    if(mid == high || nums[mid+1] != target){
                        return mid;
                    }
                    
                    low = mid+1;
                }
            
            } else if(target < nums[mid]){
                high = mid -1;
            } else {
                low = mid+1;
            }
            
        }
        return -1;
        
        
    }
}