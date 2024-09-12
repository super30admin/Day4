// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        //checking edge case
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        //capturing the lower index where target matches
        int indexFirst = binarySearchFirst(nums, target);
        // capturing the last index where target matches
        int indexLast = binarySearchLast(nums, target);
        return new int[]{indexFirst, indexLast};
    }
    
    // method to check the first occurrence of target
    public int binarySearchFirst(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            // if value at mid is larger than or equal to target, high needs to be updated. This will take care of searching leftmost index of the target 
            if (nums[mid] >= target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
            //updating index if middle value is equal to target element
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
    
    // method to check the last occurrence of target
    public int binarySearchLast(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            // if value at mid is smaller than or equal to the target, low needs to be updated. This will take care of searching rightmost index of the target 
            if (nums[mid] <= target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
            //updating index if middle value is equal to target element
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}