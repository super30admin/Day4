//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

/*
Time: O(logn)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class Minimum {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        // Block to find where start(smallest) will be, store start as left here
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

}
