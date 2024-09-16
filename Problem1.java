// Time Complexity : O(logn)
// Space Complexity : O(1)
class Solution {

  public int[] searchRange(int[] nums, int target) {
    //for this question i will need two binary search
    int startPosition = bsStart(nums, target);
    int endPosition = bsEnd(nums, target);
    return new int[] { startPosition, endPosition };
  }

  private int bsStart(int[] arr, int target) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == target) {
        if (mid == 0 || arr[mid - 1] != target) {
          return mid;
        }
        end = mid - 1;
      } else if (target < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private int bsEnd(int[] arr, int target) {
    int start = 0, end = arr.length - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == target) {
        if (mid == arr.length - 1 || arr[mid + 1] != target) {
          return mid;
        }
        start = mid + 1;
      } else if (target < arr[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
