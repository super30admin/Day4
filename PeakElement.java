//https://leetcode.com/problems/find-peak-element/

/*
Time: O(logn)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class PeakElement {

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1])
                left = mid + 1;

            else
                right = mid;

        }

        return left; // or return right

    }

}
