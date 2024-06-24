// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class Solution {
  public int findMin(int[] nums) {
    //Edge case
    if(nums.length == 0 || nums == null) return -1;

    int low = 0;
    int high = nums.length-1;

    while(low<=high) {
      // Checking if the array is sorted without rotation.
      if(nums[low]<=nums[high]) return nums[low];

      int mid = low + (high-low)/2;
      // If the element at mid is lesser than the one before and after it, return the element at mid.
      // Also check if it is the first or last element in the array.
      if((mid == 0 || nums[mid-1]>nums[mid]) && (mid == nums.length-1 || nums[mid+1]>nums[mid])) {
        return nums[mid];
      }
      // Navigate to the un-sorted half of the array.
      if(nums[low]<=nums[mid]) low = mid + 1;
      else high = mid - 1;
    }
    return nums[low];
  }
}