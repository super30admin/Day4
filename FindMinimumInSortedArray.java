public class FindMinimumInSortedArray {
  /**
   * Time Complexity: O(log(n))
   * Space Complexity: O(1)

   * Did this code successfully run on Leetcode : Yes
   * Any problem you faced while coding this : No 
   * 
   */

  public int findMin(int[] nums) {
    if(nums.length == 1) { return nums[0]; }
    int left = 0, right = nums.length-1;
    
    while(left <= right){
        int mid = left + (right - left)/2;
        
        if(
            (mid == 0 && nums[mid] < nums[mid+1]) ||
            (mid == nums.length - 1) ||
            (mid > 0 && mid < nums.length-1 && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) // getting this is the hard part
        ) {
            return nums[mid];
        } else if(nums[mid] > nums[right]) {
            left = mid+1;
        } else {
            right = mid-1;
        }
    }
    
    return -1;
  }
}
