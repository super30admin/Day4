// TC: O(log n)
// SC: O(1)
// Leetcode run: Yes



class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int ans1 = -1;
    int ans2 = -1;
    if(target == -1) {
      ans1 = -2;
      ans2 = -2;
    }

    ans1 = findFirstIndex(nums,target);
    ans2 = findLastIndex(nums,target);
    res[0] = ans1;
    res[1] = ans2;
    return res;
  }

  private int findFirstIndex(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int res = -1;
    while(start <= end) {
      int mid = start + (end - start)/2;
      if(target == nums[mid]) {
        res = mid;
        end = mid - 1;
      }
      else if(nums[mid] > target) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return res;
  }

  private int findLastIndex(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    int res = -1;
    while(start <= end) {
      int mid = start + (end - start)/2;
      if(target == nums[mid]) {
        res = mid;
        start = mid + 1;
      }
      else if(nums[mid] > target) {
        end = mid - 1;
      }
      else {
        start = mid + 1;
      }
    }
    return res;
  }
}