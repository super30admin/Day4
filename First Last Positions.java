// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int[] result;
    int left;
    int right;
    public int[] searchRange(int[] nums, int target) {
       int start=0;
       int end=nums.length-1;
        result=new int[2];
           
        result[0]=helper(nums,target,true);
        result[1]=helper(nums,target,false);
    
        
       return result;
    }
    
    public int helper(int[] nums,int target, boolean firstPos){
       int start=0;
       int end=nums.length-1;
        while(start<=end){
           int mid=start+(end-start)/2;
           if(nums[mid]<target){
               start=mid+1;
           }else if(nums[mid]>target){
               end=mid-1;
           }else{
               if(firstPos){
                   if(mid==start || nums[mid-1]!=target){
                       return mid;
                   }
                   end=mid-1;
               }else{
                   if(mid==end || nums[mid+1]!=target){
                        return mid;
                   }
                   start=mid+1;
               }
           }
       }
        
        return -1;
    }
        
     
}