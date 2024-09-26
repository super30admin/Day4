// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Modified Binary Search.
// If the current mid element is greater than the next element,
// we find the peak in the left subarray.
// If the current mid element is smaller than the next element,
// we find the peak in the right subarray.
      

class Solution {
  public int findPeakElement(int[] nums) {
      int start = 0, end = nums.length - 1;
      
      while (start < end) {
          int mid = (start + end)/2;
          
          if(nums[mid] > nums[mid+1] ) {
              end = mid;
          } else {
              start = mid + 1;
          }
      }
      
      return start;
  }
}