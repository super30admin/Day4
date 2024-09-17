// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Checking for null and empty nums array
        if (nums==null || nums.length == 0) return new int[]{-1, -1};
        int low = 0, high = nums.length-1;
        //search for first target position
        int lower = searchLowerBound(nums, low, high, target);
        //if we get lower == -1, it means there is no target in the array, hence return {-1,-1}
        if (lower == -1) return new int[]{-1, -1};
        //search for last target position, here we can send lower as the lower index for binary search since we have identified that in the previous function.
        int upper = searchUpperBound(nums, lower, high, target);
        return new int[]{lower, upper};
    }

    private int searchLowerBound(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                // check for mid==0 first so that we dont go below 0 index, otherwise it will lead to arrayIndexOutOfBound Exception
                if (mid==0 || nums[mid-1] < nums[mid]) {
                    return mid;
                }
                else if (nums[mid-1] == nums[mid]) {
                    high = mid-1;
                }
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    private int searchUpperBound(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                // check for mid==nums.length-1 first so that we dont go above nums.length-1 index, otherwise it will lead to arrayIndexOutOfBound Exception
                if (mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                }
                else if (nums[mid] == nums[mid+1]) {
                    low = mid+1;
                }
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}