// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1. Split the task in two halves, find starting index and ending index
//2. Find the target and then keep going left to check if there are more instances of target and find start index
//3. Find the target anf then keep going right to check if there are more instances of target and find ending index

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }
    
    private int findStartingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            if(nums[mid] == target) index = mid;
        }
        
        return index;
    }
    
    private int findEndingIndex(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] <= target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            if(nums[mid] == target) index = mid;
        }
        
        return index;
    }
}