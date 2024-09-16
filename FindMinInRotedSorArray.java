/**
 TC: O(n)
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length, l = 0, h = n -1, mid = 0;

        if(nums[l] < nums[h]) {
            return nums[l];
        }

        while (l <= h) {
            mid = l + (h - l) / 2;

            if(nums[l] < nums[h]) {
                return nums[l];
            }

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid ==n-1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if(nums[l]  <= nums[mid]){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return nums[l];
    }
}