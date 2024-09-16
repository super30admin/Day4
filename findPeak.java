// Time Complexity : O(2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public int findPeakElement(int[] nums) {
        //checking null condition
      if(nums == null || nums.length == 0) return -1;
      int low =0; int high = nums.length-1;
      while(low<=high) {
        //find mid
        int mid = low +(high-low)/2;
        //check neighbouring elements to find the peak
        if((mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
          return mid;
        } else if(mid!=0 && nums[mid-1] > nums[mid] ) { 
          high = mid-1;
        } else {
          low = mid+1;
        }
      }
      return 1;
    }
}