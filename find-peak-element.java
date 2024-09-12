// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
// Find mid see which side is series increasing and search to that side
public class Solution {
    public int findPeakElement(int[] nums) {
      
      int n = nums.length;
      int low = 0;
      int high = n-1;
      
      while(low<=high) {
          
          int mid = low + (high-low)/2;
          if((mid==0||nums[mid] > nums[mid-1])&&(mid==n-1||nums[mid] > nums[mid+1])) {
              return mid;
          }
          else if(nums[mid] < nums[mid+1]) {
              low = mid+1;
          } else {
              high=mid;
          }
          
      }
        return -1;
    }
}
