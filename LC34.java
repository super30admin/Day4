
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes	
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Create pointers low, high and calculate mid
//Search separately in the left and right side of the array 
//return from the both the  functions integer values which would give the first and last position of the target value.




class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = leftMostSearch(nums, target);
        int right = rightMostSearch(nums, target);
        
        return new int[]{left, right};
        
    }
    
    private int leftMostSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1] != target){
                    return mid;
                }
                high = mid - 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    private int rightMostSearch(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] != target){
                    return mid;
                }
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            } 
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}