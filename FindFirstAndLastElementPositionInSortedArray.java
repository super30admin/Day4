// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Use two different helper methods whis are binary search
// with different start and end points.
// For finding the first index, if we find nums[mid] >= target,
// we move towards the left subarray by making end = mid - 1.
// For finding the last index, if we find nums[mid] <= target,
// we move towards right subarray by making start = mid + 1.

class Solution {
  public int[] searchRange(int[] nums, int target) {
      if(nums == null || nums.length == 0) {
          return new int[] {-1, -1};
      }
    
      int first = -1, last = -1;
      
      first = findFirst(nums, target);
                     
      if(first == -1) {
          return new int[]{first, last};
      }
      
      last = findLast(nums, target);
      
      return new int[]{first, last};
  }
  
  public int findFirst(int[] nums, int target) {
      int index = -1;
      int start = 0;
      int end = nums.length - 1;
      
      while(start <= end) {
          int mid = (start + end)/2;
          
          if(nums[mid] < target) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }
          
          if(nums[mid] == target) {
             index = mid;
          }
      }
      
      return index;
  }
  
  public int findLast(int[] nums, int target) {
      int index = -1;
      int start = 0;
      int end = nums.length - 1;
      
      while(start <= end) {
          int mid = (start + end)/2;
          
          if(nums[mid] <= target) {
              start = mid + 1;
          } else {
              end = mid - 1;
          }
          
          if(nums[mid] == target) {
              index = mid;
          }    
      }
      
      return index;
  }
}