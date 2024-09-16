// Time Complexity : O(logn)
// Space Complexity : O(1)
class Solution { //using binar

  public int findMin(int[] nums) {
    int start = 0, end = nums.length - 1;
    int min = 0;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (nums[start] <= nums[end]) return nums[start];
      if (mid != 0 && nums[mid - 1] > nums[mid]) return nums[mid];
      if (nums[start] <= nums[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return 5001;
  }
}
