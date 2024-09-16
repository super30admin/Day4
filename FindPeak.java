// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FindPeak {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else {
                if (nums[mid] < nums[mid + 1])
                    i = mid + 1;
                else
                    j = mid - 1;
            }
        }


        return -1;
    }
}