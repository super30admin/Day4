/*
 * Time Complexity: O(Log(N)) for binary search approach.
 * Space Complexity: O(1) constant space.
 * */
class Solution {
  public int findMin(int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int left = 0, right = nums.length - 1;

    if (nums[right] > nums[0]) {
      return nums[0];
    }
    
    // Binary search 
    while (right >= left) {
      int mid = left + (right - left) / 2;

      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }

      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }

      // if the mid elements value is greater than the 0th element
      if (nums[mid] > nums[0]) {
        left = mid + 1;
      } else {
        // if nums[0] is greater than the mid value
        right = mid - 1;
      }
    }
    return -1;
  }
}