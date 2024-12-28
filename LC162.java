// 162. Find Peak Element

// TC: O(log(n))
// SC: O(1)
// Solved in LC: Yes

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (mid == 0 || nums[mid - 1] < nums[mid])
                l = mid + 1;
            else
                h = mid - 1;
        }
        return -1;
    }
}