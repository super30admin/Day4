// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int[] searchRange(int[] nums, int target) {
    if(nums.length == 0 || nums == null) return new int[]{-1,-1};
    int low = 0;
    int high = nums.length-1;
    int lowerBound = getLowerBound(nums, low, high, target);
    // If the first index is -1 then there is no need to check last index.
    if(lowerBound == -1) return new int[]{-1,-1};
    int higherBound = getHigherBound(nums, low, high, target);
    return new int[]{lowerBound, higherBound};
  }

  // Helper function to let the lower bound of target Element.
  int getLowerBound(int[] nums, int low, int high, int target) {
    while(low<=high) {
      int mid = low + (high - low)/2;
      if(target == nums[mid]) {
        // If mid is 0 there is no element before it.
        if(mid == 0 || target!=nums[mid-1]) return mid;
        else high = mid-1;
      } else if(target < nums[mid]) high = mid-1;
      else low = mid + 1;
    }
    return -1;
  }

  // Helper function to let the higher bound of target Element.
  int getHigherBound(int[] nums, int low, int high, int target) {
    while(low<=high) {
      int mid = low + (high - low)/2;
      if(target == nums[mid]) {
        // If mid is the last element, there is nothing after it.
        if(mid == nums.length-1 || target!=nums[mid+1]) return mid;
        else low = mid+1;
      } else if(target < nums[mid]) high = mid-1;
      else low = mid + 1;
    }
    return -1;
  }
}