// Time Complexity : O(log)n
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        if(target < nums[0] || target > nums[nums.length -1]) return new int[] {-1,-1};
        
        int firstOccurence = binarySearchFirst(nums, target);
        if(firstOccurence  == -1) return new int[] {-1,-1};
        
        int lastOccurence = binarySearchLast(nums, target);
        return new int[]{firstOccurence,lastOccurence};
        
    }
    
    private int binarySearchFirst(int[] nums, int target){
        
        int low = 0;
        int high = nums.length -1;
        
        while(low<=high){
            int mid = low + (high -low)/2;
            if(target == nums[mid]){
                if(mid == 0 || nums[mid -1] < nums[mid]){
                    return mid;
                }else{
                    high = mid - 1;
            }
                 }  
            else if(target < nums[mid]){
                high = mid -1;
            }
            else{
                    low = mid + 1;
                }
            
        }
        return -1;
    }
    
    private int binarySearchLast(int[] nums, int target){
        
        int low= 0;
        int high = nums.length -1;
        
        while(low <=high){
            int mid = low+(high-low)/2;
            if(target == nums[mid]){
                if(mid == nums.length -1 || nums[mid+1] > nums[mid]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(target < nums[mid]){
                high = mid -1;
            }
             else{
                low = mid + 1;
            }
        }
        return -1;
    }
}