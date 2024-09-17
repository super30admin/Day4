/** Executed on LeetCode: No Problems */

/** Time Complexity: O(log n) 
 * Spache Complexity: O(1)
*/

/** Explanation:
 * We are running two binary search once to find starting position and the other time to find the ending position.
 * Intution: A boolean variable keeps track on how to shift search bounds.
*/


class Solution {
  public int[] searchRange(int[] nums, int target) {
      int[] res = {-1,-1};
      res[0] = findBound(nums, target, false);
      res[1] = findBound(nums, target, true);
      return res;
      
  }
  
  public int findBound(int[] nums, int target, boolean upper) {
      int low = 0;
      int high = nums.length-1;
      int bound = -1;
      
      while(low<=high) {
          int mid = low + (high-low)/2;
          if(nums[mid] == target) {
              bound = mid;
              if(upper) {
                  low = mid + 1;
              } else 
                  high = mid - 1;
          } else if(nums[mid] < target) {
              low = mid + 1;
          } else {
              high = mid - 1;
          }
      }
      
      return bound;
  }
}