// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
   private int leftIndex;
  
   private int leftIndexSearch(int[] nums, int target) {
      int low = 0; int high = nums.length-1;
      
      while(low<=high) {
        int mid = low+(high-low)/2;
        if(nums[mid] == target) {
            if(mid == low || nums[mid] > nums[mid-1]) {
              leftIndex = mid;
              return mid;
            } else {
              high = mid-1; //move left
            }
        }else  if(nums[mid] >target){
               high = mid -1;
          } else {
              low = mid + 1;
          }
      }
        return -1;
    }
  
  private int rightIndexSearch(int[] nums, int target) {
      int low = leftIndex; int high = nums.length-1;
      
      while(low<=high) {
        int mid = low+(high-low)/2;
        if(nums[mid] == target) {
            if(mid == high || nums[mid] < nums[mid+1]) {
              return mid;
            } else{
              low = mid+1; //move left
            }
         }else  if(nums[mid] >target){
               high = mid -1;
          } else {
              low = mid + 1;
          }
       }
      return -1;
   }
    public int[] searchRange(int[] nums, int target) {
      if(nums == null || nums.length == 0) {
        return new int[]{-1,-1};
      }
      
      if(target < nums[0] || target > nums[nums.length-1])
      {
        return new int[]{-1,-1};
      }
      int left = leftIndexSearch(nums, target);
       if(left == -1) return new int[] {-1,-1};
      int right = rightIndexSearch(nums, target);
      return new int[] {left,right};
    }
      
}