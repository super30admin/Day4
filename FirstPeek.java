// Time Complexity - O(logN)
// Space Complexity - O(logN)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// we use binary search to solve this problem.
// the idea is to compare the middle element with the next element
// if the mid is smaller than the next element then the peek is in the left subarray
// or else its in the right subarray

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high-low)/2;
            
            if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
}