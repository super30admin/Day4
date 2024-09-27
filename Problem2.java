//Problem 2: find-minimum-in-rotated-sorted-array

//Time Complexity: log(n) 
//Space: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Approach used: Binary search; search till the time you are not at a position where there is a pivot element
class Solution {
  public int findMin(int[] nums) {
      int low = 0;
      int high = nums.length - 1;
      int n = nums.length - 1;

      while(low < high)
      {
          if (nums[low] < nums[high]) return nums[low];
          int mid = low + (high-low)/2;
          if((mid == 0 || nums[mid] < nums[mid - 1]) &&  nums[mid] < nums[mid + 1])
          {
              return nums[mid];
          } 
          else if(nums[mid] < nums[high])
          {
             high = mid - 1;
          } 
          else
          {
            low = mid + 1;
          }
      }
      return nums[low];
  }

}