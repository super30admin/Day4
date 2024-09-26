class Solution {
  public int findMin(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    if (nums.length == 1)
      return nums[0];

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[left] <= nums[right])
        return nums[left];

      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];

  }
}
