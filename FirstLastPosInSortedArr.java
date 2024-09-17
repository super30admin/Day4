//Exercise_8 : First and Last Position in Sorted Array
// Time Complexity : O(log(N))
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
/*
Implemented two binary search functions, one for finding first index , other one fo finding the last index. For Finding the first position, whenever arr[mid]==target, just store the index and move end pointer to mid-1 because first position will only be on left side. Similarly for finding the last position,whenever arr[mid]==target, just store the index and move start pointer to mid+1 because last position will only be on the right side 
*/

class Solution8 {
    public int[] searchRange(int[] nums, int target) {
        
        int[] res = new int[]{-1,-1};
        
        if(nums==null || nums.length==0){
            return res;
        }
        
        res[0] = getFistIndex(nums,target);
        res[1] = getLastIndex(nums,target);
        
        return res;
    }
    
    private int getFistIndex(int[] nums, int target){//floor methodology
        
        int start = 0;
        int end   = nums.length-1;
        int res = -1;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(target==nums[mid]){
                res = mid;
                end = mid-1;
            }else if(target<nums[mid]){
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }
            
        }
        
        return res;
    }
    
    
    private int getLastIndex(int[] nums, int target){//ceil methodology
        
        int start = 0;
        int end   = nums.length-1;
        int res = -1;
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(target==nums[mid]){
                res   = mid;
                start = mid+1;
            }else if(target<nums[mid]){
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }
            
        }
        
        return res;
    }
    
}