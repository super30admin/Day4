// space complexity - O(1)
//time - O(log(n))
//Ran on leeetcode successfully : Yes
// Problem faced  : No
//Approach : Binary Search, find mid, if mid lies on the decreasing slop then move end to mid(dont do mid -1 'causee mid might be the peak element ')
       // if mid lies on increasing slop then move start = mid+1

class Solution {
    public int findPeakElement(int[] nums) {

      if(nums == null && nums.length == 0) return -1;

      int start = 0;
      int end = nums.length -1;
      int mid = start + (end - start)/2;

      while(start <= end){
        mid = start + (end - start)/2;

        if(start == end) return start;

        if(nums[mid] < nums[mid+1]){
          start = mid + 1;
        }

        else if(nums[mid] > nums[mid+1]){
          end = mid;
        }
      }

      return -1;
    }
}
