//Time complexity O(logn)
//Space Complexity O(1)
class Solution {
    public int findPeakElement(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // peak contion
            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1]))
                return mid;
            if (nums[mid] < nums[mid + 1])// implies that peek tends to right part
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}