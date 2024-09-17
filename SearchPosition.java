//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
Time: O(logn)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class SearchPosition {

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = findStart(nums, target);
        result[1] = findEnd(nums, target);
        return result;

    }

    public int findStart(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid])
                index = mid;

            if (target <= nums[mid])
                right = mid - 1; // We found the element but we still want to move to the left

            else
                left = mid + 1;

        }

        return index;
    }

    public int findEnd(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == nums[mid])
                index = mid;

            if (target >= nums[mid])
                left = mid + 1; // We have to keep moving right (to find end index) even though we found the
                                // target

            else
                right = mid - 1;

        }

        return index;
    }

}
