// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        
        while (low <= high) {
            if (nums[low] < nums[high]) return nums[low]; // if both sides are sorted, first element is minimum
            int mid = low + (high - low)/2;
            if ((mid == 0 || nums[mid] < nums[mid-1]) && 
                (mid == nums.length-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) { // left side is sorted, move to right
                low = mid + 1;
            } else { // right side is sorted, move to left
                high = mid - 1;
            }
        }
        
        return -1;
    }
}