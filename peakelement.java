//Time Complexity : O(log N)
//Space Complexity : O(1)
// did you try it on leetcode : yes

class Solution {
    public int findPeakElement(int[] nums) {
         int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid =low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return l;
    }
}