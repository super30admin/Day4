// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int searchFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;                    //Searching the first occurence using binary search
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1])
                    return mid;
                r =  mid - 1;
            } else if (target < nums[mid])
                r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    public int searchSecond(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {                        //Searching the first occurence using binary search
            int mid = l + (r - l)/2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
                    return mid;
                l =  mid + 1;
            } else if (target < nums[mid])
                r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int x = searchFirst(nums, target);
        if (x == -1)                        //if element is not found, we will not perform second binary search
            return new int[]{-1, -1};
        return new int[]{x, searchSecond(nums, target)};
    }
}