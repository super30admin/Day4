// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int low =0; int high = nums.length-1, mid;
        while(low<=high) {
          mid = low +(high-low)/2;
          if(nums[low] <= nums[high]) 
          {
            return nums[low];
          }
          if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid]< nums[mid+1])) {
            return nums[mid];
          } else if(nums[low] <= nums[mid]) {
            low = mid+1;
          } else {
            high = mid+1;
          }
        }
      return 1;
    }
}
