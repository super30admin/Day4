class Solution {
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - do indiviual binary search to find start and end position of target. To find start pos, when nums[mid] is equal
    // to target, set start equal to mid and search on left half for any potential matches. To find end pos, when nums[mid] is equal
    // to target, set end equal to mid and search on right half for any potential matches.
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};

        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        result[0] = start;
        result[1] = end;
        return result;
    }

    public int findStart(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        int start = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                start = mid; //search on left
                high = mid-1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return start;
    }

    public int findEnd(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        int end = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                end = mid; //search on right
                low = mid+1;
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return end;
    }
}