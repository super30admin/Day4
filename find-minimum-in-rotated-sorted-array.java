// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
  public int findMin(int[] nums) {
    
      int n = nums.length;
      
      if(n==1) return nums[0];
      
      int low = 0;
      int high = n-1;
      
      while(low<=high) {
          
          int mid = low + (high-low)/2;
          
          // if we reach first index or last index and that is min to its neighbouring index
          // or (mid-1) > mid < (mid+1) that will be the ans
          // else do binary search
          if((mid==0 && nums[mid]<nums[mid+1]) || 
             (mid==n-1&&nums[mid]<nums[mid-1]) || 
             (mid>0&&mid<n-1&&nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1])) {
              return nums[mid];
          } else if(nums[mid] > nums[high]) {
              low = mid+1;
          } else {
              high=mid-1;
          }
          
      }
    return -1;
  }
}
