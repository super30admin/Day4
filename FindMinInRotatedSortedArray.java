// Time Complexity : Binary Search - O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES

class Solution {
    public int findMin(int[] nums) {
      int min = Integer.MAX_VALUE;
      int low = 0;
      int high = nums.length-1 ;
      while (low <= high)
      {
          int mid = low + (high-low)/2;
          min = Math.min(min, nums[mid]);
          if(nums[low] <= nums[mid])
          {
              if(nums[low] <= nums[high] && nums[mid] <= nums[high])
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1;
              }
          }
          else
          {
              if (nums[low] >= nums[high] && nums[mid] <= nums[high])
              {
                  high = mid - 1;
              }
              else
              {
                  low = mid + 1 ;
              }
          }
      }
      return min;
    }
}
