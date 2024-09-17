/** LeetCode Execution: Done, No Problem */

/** Solution 1
 * Time Complexity: O(log n) - 
 * Space Complexity: O(log n) - Size of recursion stack
 * 
 * Solution 2
 * Space Complexity: O(1) - No recursion
*/

/**
 * The approach is very close to the solution of fiding pivot, here peak element is like a local peak/inflection point.
 */

class Solution {
  public int findPeakElement(int[] nums) {
      return bsHelper(nums, 0, nums.length - 1); // Solution 1
      // Solution 2
      // return bsHelper2(nums, 0, nums.length - 1);
      
  }
  
  private int bsHelper(int[] nums, int l, int r) {
      if (l == r)
          return l;
      int mid = l + (r-l)/2;
      if (nums[mid] > nums[mid+1]) {
          return bsHelper(nums, l, mid);
      }
      return bsHelper(nums, mid + 1, r);
  }


  // Solution 2: Iterative
  private int bsHelper2(int[] nums, int l, int r) {
        
    while (l<r) {           // This time we want to break when l == r
        int mid = l + (r-l)/2;
        
        if (nums[mid] > nums[mid + 1]) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    
    return l;
}
}

