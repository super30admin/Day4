//Time Complexity: O(log n)
//Space Complexiy: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                right = mid - 1;
            else if (mid < length - 1 && nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                return mid;
        }
        return 0;
    }

}