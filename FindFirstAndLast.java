public class FindFirstAndLast {

  /*
  Time Complexity: O(log(n))
  Space Complexity: O(1)

  Did this code successfully run on Leetcode : Yes
  Any problem you faced while coding this : No 
  */
  private int binarySearchFirst(int[] nums, int target){
    int left = 0, right = nums.length-1;
    
    while(left <= right){
        int mid = left + (right - left)/2;
        
        if(nums[mid] == target && (mid == 0 || nums[mid-1] < target)){
            return mid;
        } else if(nums[mid] == target) {
            right = mid-1;
        } else if (nums[mid] > target) {
            right = mid -1;
        } else {
            left = mid+1;
        }
    }
    
    return -1;
  }

  private int binarySearchLast(int[] nums, int target, int start){
      int left = start, right = nums.length-1;
      
      while(left <= right) {
          int mid = left + (right - left)/2;
          
          if(nums[mid] == target && (mid == nums.length-1 || nums[mid+1] > target)) {
              return mid;
          } else if(nums[mid] == target) { //The peak is further on the right side.
              left = mid+1;
          } else { // we can never have elements less than the target so we only ever have to move the right pointer.
              right = mid-1;
          }
      }
      
      return -1;
  }

  public int[] searchRange(int[] nums, int target) {

    // Early exit conditions.
    if(nums == null || nums.length == 0) return new int[] { -1, -1 };
    if(nums[0] > target || nums[nums.length-1] < target) return new int[] { -1, -1 };
    
    int start_idx = binarySearchFirst(nums, target);
    
    if(start_idx  == -1) { return new int[]{-1, -1}; }
    
    int end_idx = binarySearchLast(nums, target, start_idx); // Just send down the start_idx to reduce input size.
    
    return new int[]{start_idx, end_idx};
  }
}
