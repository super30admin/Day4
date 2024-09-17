// Time Complexity : O(logn) where n is the size of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        
        int low = findLowerLimit(nums, 0, nums.length-1, target);
        if(low == -1) return new int[]{-1,-1};
        
        int high = findHigherLimit(nums, low, nums.length-1, target);
        
        return new int[]{low, high};
    }
    
    private int findLowerLimit(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    private int findHigherLimit(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}
