// Time Complexity : O(logn)
// Space Complexity : O(1)
class Solution {

  public int findPeakElement(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;
      boolean gtThanLeft = mid == 0 || nums[mid] > nums[mid - 1];
      boolean gtThanRight = mid == nums.length - 1 || nums[mid] > nums[mid + 1];

      if (gtThanLeft && gtThanRight) return mid; else if (gtThanLeft) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }
}
