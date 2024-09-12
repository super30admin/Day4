// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Binary search for start index of target and binary search for last index of target
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int n = nums.length;
        if(n==0) {
            return new int[]{-1,-1};
        }
        
        int low = binarySearchLeft(nums, target);
        if(low==-1)  return new int[]{low,low};
        
        int high = binarySearchRight(nums, target, low);
        
        return new int[]{low,high};
        
    }
    
    public int binarySearchLeft(int[] nums, int target) {
        int n = nums.length;
        int low=0;
        int high = n-1;
        while(low<high) {
          
         int mid = low + (high-low)/2;
         if(nums[mid] < target) {
              low = mid+1;
          } else {
              high=mid;
          }
          
      }
        return nums[low]==target?low:-1;
    }
    
    public int binarySearchRight(int[] nums, int target, int low) {
        int n = nums.length;
        int high = n-1;
        while(low<high) {
          
          int mid = low + (high-low)/2;
          
          if(nums[mid] <= target && nums[mid]==nums[mid+1]) {
              low = mid+1;
          } else {
              high=mid;
          }
          
      }
        return low;
    }
    
    
}
