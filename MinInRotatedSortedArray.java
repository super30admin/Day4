/**
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class MinInRotatedSortedArray {

  public int findMin(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      if (nums[low] <= nums[high]) {
        return nums[low];
      }
      int mid = low + (high - low) / 2;
      if ((mid == low || (nums[mid - 1] > nums[mid])) && (mid == high || (nums[mid + 1] > nums[mid]))) {
        return nums[mid];
      }
      if (nums[low] <= nums[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return Integer.MIN_VALUE;
  }
}