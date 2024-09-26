// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class FindPeak {

    public int findPeakElement(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
