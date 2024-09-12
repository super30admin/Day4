// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[] {-1,-1};
        if(target < nums[0] || target > nums[nums.length - 1])
            return new int[] {-1,-1};
        
        int firstOccurence = firstOccurence(nums, target);
        if (firstOccurence == -1){
            return new int[] {-1,-1};
        }
        
        int secondOccurence = secondOccurence(nums, target, firstOccurence);
        return new int[] {firstOccurence, secondOccurence};
    }
    
    private int firstOccurence(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1] < target)
                    return mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                    low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
    private int secondOccurence(int[] nums, int target, int firstOccurence){
        int low = firstOccurence;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target)
                    return mid;
                low = mid + 1;
            }
            else if(target < nums[mid])
                high = mid - 1;
            else{
                low = mid + 1;
            }
            
        }
        return -1;
    }
    
}
