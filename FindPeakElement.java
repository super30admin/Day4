// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int findPeakElement(int[] nums) {
    //Edge cases.
    if(nums.length == 0 || nums == null) return -1;
    int low = 0;
    int high = nums.length-1;
    while(low<=high) {
      // To prevent interger overflow.
      int mid = low + (high-low)/2;
      // Checking if the element at mid is a peak.
      if((mid == 0 || nums[mid-1]<nums[mid]) && (mid == nums.length-1 || nums[mid]>nums[mid+1])) {
        return mid;
      }
      // Moving the pointers towards the higher element for better chance of finding a peak.
      if(nums[mid+1]>nums[mid]) low = mid+1;
      else high = mid-1;
    }
    return low;
  }
}