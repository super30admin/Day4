// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: At every iteration checked if the value at mid is greater than value at end, 
// if this is true => the minimum element is still towards the right of mid, make the start as mid + 1
// else our minimum element is towards the left of mid, make end as mid - 1. 

class Solution {
  public int findMin(int[] nums) {
      if(nums == null || nums.length == 0) {
          return -1;
      }
      
      int start = 0, end = nums.length - 1;
      
      while(start < end) {
          int mid = (start + end)/2;
          
          if(nums[mid] > nums[end]) {
              start = mid + 1;
          } else {
              end = mid;
          }
      }
      
      return nums[start];
  }
}