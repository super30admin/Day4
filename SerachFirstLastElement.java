// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    private int  binarysearchlast(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if (mid == nums.length-1 || nums[mid+1] > target)
                {
                    return mid;
                }
                else{
                        low= mid+1;
                    }
                }
            else if(nums[mid]<target){
                low = mid+1; 
            }else {
               high = mid-1;
            }
        }
    return -1;
    }
    
    private int  binarysearchfirst(int[] nums, int low, int high, int target){
       while(low<=high){
           int mid= low + (high-low)/2;
           if(nums[mid]==target)
           {
               if(mid==0 || nums[mid-1] < target) return mid;
              else{
                  high= mid-1;
                    }    
            }else if (nums[mid]<target){
                 low= mid+1;
            }else{
                 high= mid-1;  
               }
                   
           }
        return -1;
       } 
    
    
    public int[] searchRange(int[] nums, int target) {
        // null check
        if (nums== null || nums.length <= 0) return new int []{-1,-1};
        int result[]= new int[2];
        // check if in sorted array target is smaller then first or larger than last element 
        if(target < nums[0] || target > nums[nums.length-1])return new int []{-1,-1};
      //find first in array
        int first = binarysearchfirst(nums, 0, nums.length-1, target);
        // if not found
        if(first == -1) return new int []{-1,-1};
        // find last 
        int last = binarysearchlast(nums, first, nums.length-1, target);
        return new int[]{first,last};
    }
}