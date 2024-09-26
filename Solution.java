// Time Complexity : O(logN) where N is the number of element in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetIndexArr = {-1,-1};
        if(nums.length == 0){
            return targetIndexArr;
        }
        
        if(nums.length == 1){
            return (nums[0] == target) ? new int[] {0,0} : targetIndexArr; 
        }
        
        int low = 0;
        int high = nums.length-1;
                
        targetIndexArr[0] = binSearchStart(nums, low, high, target);
        targetIndexArr[1] = binSearchEnd(nums, low, high, target);
        
        return targetIndexArr;
    }
    
    public int binSearchStart(int[] nums, int start, int end, int target){
        
        if(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target && (start == mid || nums[mid-1] < target)){
                return mid;
            }
            if(nums[mid] >= target){
                return binSearchStart(nums, start, mid-1, target);
            }
            else{
                return binSearchStart(nums, mid+1, end, target);
            }
        }        
        return -1;        
    }
    
     public int binSearchEnd(int[] nums, int start, int end, int target){
        
        if(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target && (end == mid || nums[mid+1] > target)){
                return mid;
            }
            if(nums[mid] > target){
                return binSearchEnd(nums, start, mid-1, target);
            }
            else{
                return binSearchEnd(nums, mid+1, end, target);
            }
        }        
        return -1;        
    }
}
