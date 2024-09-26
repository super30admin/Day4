

// Time Complexity: 0(logN)
//Space Complexiy: O(1)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
//Memory Usage: 41.8 MB, less than 97.13% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// struggled a bit with edge cases


class Solution {
  public int[] searchRange(int[] nums, int target) {
    return new int[] {
      searchFirstTarget(nums, target), searchSecondTarget(nums, target)
    };
  }

  private int searchFirstTarget(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    if (low >= nums.length || low < 0) return -1;
    return nums[low] == target ? low : -1;
  }

  private int searchSecondTarget(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        low = mid + 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    if (low - 1 < 0) return -1;
    return nums[low - 1] == target ? low - 1 : -1;
  }
}
