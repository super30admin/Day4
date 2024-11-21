//Time complexity : O(logn)
//Space complexity : O(1)
//Leetcode : success

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
        int[] res = new int[2];
        res[0] = findfirst(nums,target);
        res[1] = findsecond(nums,target);
        
        return res;
        }
        
    static int findfirst(int[] nums, int target){
        
        int start = 0;
        int end = nums.length - 1;
            
        while(start<= end){
           
        int mid = start + (end-start)/2;
            
        if(nums[mid]==target){
            
            if(mid == start || nums[mid-1]<nums[mid]){
                return mid; 
            }else{
                end = mid -1;
            }
        
        }else if(nums[mid]>target){
                end = mid -1;
        }else{
                start = mid +1;
        }    
        }
        return -1;
        }
      
    static int findsecond(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        
        while(start<= end){
           
        int mid = start + (end-start)/2;
            
        if(nums[mid]==target){
            
            if(mid == end || nums[mid+1]>target){
                return mid; 
            }else{
                start = mid +1;
            }
        
        }else if(nums[mid]>target){
            end = mid -1;
        }else{
            start = mid +1;
        }   
        }
        return -1;
        } 
        
}