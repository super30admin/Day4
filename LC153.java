// 153. Find Minimum in Rotated Sorted Array

// TC: O(log(n))
// SC: O(1)
// Solved in LC: Yes

// Approach 1
class Solution1 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            if (nums[l] < nums[h])
                return nums[l];
            int mid = (l + h) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[l] <= nums[mid]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
}

// Approach 2
class Solution2 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        int ref = nums[h];
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] > ref) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return nums[l];
    }
}