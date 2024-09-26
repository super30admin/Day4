// Time Complexity : O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binaryLeftMost(nums, target);     
        int end = binaryRightMost(nums, target);     
        return new int[]{start, end}; 
    }
    
    private int binaryLeftMost(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = left  + (right - left)/2;
            if(nums[mid]==target){ 
                if(mid==left || nums[mid-1]!=target){
                    return mid;
                }
                right = mid -1;
            }else if(target > nums[mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
    
    private int binaryRightMost(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = left  + (right - left)/2;
            if(nums[mid]==target){ 
                if(mid==right || nums[mid+1] != target){
                    return mid;
                }
                left = mid +1;
            }else if(target > nums[mid]){
                left = mid +1;
            }else{
                right = mid -1; 
            }
        }
        return -1;
    }
}