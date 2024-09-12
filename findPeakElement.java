// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// we can work with binary search here since, 
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        if(nums.length == 1) return 0;
        if(nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
        
        int low = 0;
        int high = nums.length - 1;
        while(low < high-1){// indexing 
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){  //found peak
                return mid;
            }
            else if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){ //descending peak will be at left
                high = mid - 1;
            }
            else{ 
                low = mid + 1; 
            }
        }
        return nums[low] > nums[high] ? low : high; // check if which is greater as we will stop at diff values
    }
}