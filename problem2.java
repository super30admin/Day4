// TC: O(log n)
// SC: O(1)
// Leetcode run: Yes


class Solution {
  public int findMin(int[] nums) {
    int n = nums.length - 1;

    if(n==0)
      return nums[0];
    if(n==1)
      return Math.min(nums[0], nums[1]);
    if(nums[0] <= nums[n]) {
      return nums[0];
    }

    int start = 0, end = n, res = Integer.MIN_VALUE;
    int mid = Integer.MIN_VALUE;
    while(start < end) {
      mid = start + (end - start)/2;
      if(nums[mid] < nums[end]) {
        res = nums[mid];
        end = mid;
      }
      else {
        start = mid+1;
      }
    }

    return nums[start];
  }
}