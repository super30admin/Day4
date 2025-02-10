//This solution uses binary search to find the peak by checking if the peak element is found on the left or right side
//Time Complexity:O(log n)
//Space complexity: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        if (nums.length < 2) {
            return 0;
        }
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else
                high = mid;
        }
        return low;
    }
}