// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/find-peak-element/description/
// Any problem you faced while coding this : No


class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(nums.length==1 ) return 0; // To check if length is 1
        if(nums[0]>nums[1]) return 0; // To check if first element is peak
        if(nums[n-1]>nums[n-2]) return n-1; // To check if last element is peak

        int low = 1, high = nums.length-2;

          while(low<=high){
              int mid = low+(high-low)/2; // To check the mid

              if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                  return mid;
              }

              else if(nums[mid]>nums[mid-1]){
                  low = mid+1;
              }else{
                  high = mid-1;
              }
          }
        return -1;
    }
}
