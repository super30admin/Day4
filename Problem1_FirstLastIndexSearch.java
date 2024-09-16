// Time Complexity : o(logn)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        
        int[] result=new int[2];
        result[0]=findIndex(nums,target,true);
        result[1]=findIndex(nums,target,false);
        return result; 
        
    }
    
    private int findIndex(int[] nums,int target,boolean doFirst)
    {
       int low=0;
        int high=nums.length-1;
        
        
         while(low<=high)
         {
             int mid=low+(high-low)/2;
             
                 if(nums[mid]== target)
                 {
                     //first occurence
                     if(doFirst)
                     {
                         if(mid==0 || nums[mid]>nums[mid-1])
                             return mid;
                         else
                             high=mid-1;
                     }
                     //last occurence
                     else
                     {
                         if(mid==nums.length-1 || nums[mid]<nums[mid+1])
                             return mid;
                         else
                             low=mid+1;
                     }
                     
                 }
             else if(nums[mid]>target)
                 high=mid-1;
             else
                 low=mid+1;
            
         }
        return -1;
    }
    
    
}