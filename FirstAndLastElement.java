// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0)
            return new int[]{-1,-1};
        int low=0; 
        int high = nums.length-1;
        
        int left =leftsearch(nums,low,high,target);
        int right =rightsearch(nums,low,high,target);
        return new int[]{left,right};
    }
    
    public int leftsearch(int[] nums,int low,int high,int target){
        int mid = (high+low)/2;
        if(low==high){
            if(nums[high]==target)
                return low;
            else
                return -1;}
        
        if(nums[low]==nums[high]&& nums[high]==target)
            return low;
        if(nums[mid]>target || nums[mid]== target)
            return leftsearch(nums,low,mid,target);
        else if(nums[mid]<target)
            return leftsearch(nums,mid+1,high,target);
        return -1;
       
    }
       public int rightsearch(int[] nums,int low,int high,int target){
        int mid = (high+low)/2;
           if(high-low==1){
               if(nums[high]==target)
                   return high;
               else if(nums[low]==target)
                   return low;
               else return -1;
               
               }
        if(low==high){
            if(nums[high]==target)
                return high;
            else
                return -1;}
        
        if(nums[low]==nums[high]&& nums[high]==target)
            return high;
        if(nums[mid]<target|| nums[mid]==target)
            return rightsearch(nums,mid,high,target);
        else if(nums[mid]>target)
            return rightsearch(nums,low,mid-1,target);
        return -1;
       }
}