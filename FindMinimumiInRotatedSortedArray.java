// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;

        if(nums[high] > nums[low]) return nums[low];

        while(low <= high) {
            int mid = low + (high - low) /2;

            if(nums[mid] > nums[mid +1]) {
                return nums[mid+1];
            }

            if (nums[mid] < nums[mid -1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        return -1;

    }
}