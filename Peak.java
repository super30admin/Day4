// Time Complexity : O(log n) since we are doing binary search on the direction with greater element
// Space Complexity : O(1) iterative
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : handling cases if the peak is at mid == 0 and length -1.
/* Algorithm: We first find the mid element and then compare the mid element with its neighbors. First we check if it itself is a peak element or not.
Elsewise, we check with the previous element or the next element to decide which direction we could go to.*/
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length -1;
        if(nums.length == 0 || nums == null){
            return -1;
        } 
        if(nums.length == 1){return start;}
        while(start<=end){
            int mid = (start)+ (end-start)/2;
            if(mid != 0 && mid != nums.length-1 && nums[mid] > nums[mid-1] && nums[mid]>nums[mid+1]){ // checking if it itself is peak
                return mid;
            } else 
            if(mid == 0 && nums[mid] > nums[mid+1]){
                return mid;                             // Case where peak is at index 0
            } else
            if(mid == nums.length-1 && nums[mid] > nums[mid-1]){            // Case where peak is at the last position
                return mid;
            } else
            if(mid != 0 && nums[mid] < nums[mid - 1]){          // Checking which direction I could go to in search for peak
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;                      // Peak not found
        }
    }
