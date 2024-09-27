// Time Complexity: O(log n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No (Not sure about space complexity)

class Solution {
    public int findPeakElement(int[] nums) {
      int start = 0;
      int end  = nums.length-1;
        
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]){
                end = mid;
            }else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
        }
        return start;
    }
}