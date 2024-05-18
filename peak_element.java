// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(mid > low && nums[mid] < nums[mid - 1]){
                    high = mid - 1;
            }
            else if(mid < nums.length-1  && nums[mid] < nums[mid + 1]){
                    low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}