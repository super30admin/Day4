// Time Complexity: O(log n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach in three sentences only
/**
 * Approach: 
 * In this problem I have to check first and last position of element in sorted array.
 * So, first I checked for empty array or the target being out of bound then return [-1,-1] in such cases.
 * Then I perform two Binary Search methods: One to find first occurrence of the target and another to Last occurrence of the target.
 * If the target is found then the methods return the indices of these occurrences, if target is not found return [-1,-1].
 */ 
class Solution {
    public int[] searchRange(int[] nums, int target) {

        //Initialize result array with default value, if target is found returned the 
        // first and last indexes of target element otherwise I retured default array [-1,-1].
        int result[] = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        // Check if array is null or empty then return default array.
        if(nums == null || nums.length == 0) {
            return result;
        }

        // If target is not in the range of array then return default array[-1,-1].
        if(target < nums[0] || target > nums[nums.length-1]) {
            return result;
        }

        // Call the bianry search method to find the First occurrence of the target. 
        int firstOccurence = binarySearchFirst(nums, target);

        if(firstOccurence == -1) {
            return result;
        }

        // Call the bianry search method to find the Last occurrence of the target.
        int lastOccurence = binarySearchSecond(nums, target);
        result[0] = firstOccurence;
        result[1] = lastOccurence;
        return result;
    }

    // Helper method to find the first occurrence of the target using Binary Search
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if((mid == 0) || (nums[mid -1] != nums[mid])) {
                    return mid;
                }
                high = mid - 1;               
            } else if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Helper method to find the Last occurrence of the target using Binary Search
    private int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length-1 || nums[mid+1] != nums[mid]) {
                    return mid;
                }
                low = mid + 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                 high = mid - 1;
            }
        }
        return -1;
    }
}


