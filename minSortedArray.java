
class Solution {

    public int findMin(int[] nums) {
        // 2 cases
        // case 1  if left side is sorted check right
        // case 2 if right is sorted check left
        int l = 0;
        int r = nums.length - 1;
        int mid;
        int min_val = Integer.MAX_VALUE;

        while (l <= r) {
            mid = l + (r - l) / 2;
            min_val = Math.min(nums[mid], min_val);
            if (nums[l] < nums[r]) {
                min_val = Math.min(nums[l], min_val);
                return min_val;
            }
            // case 1 if left is sorted move right
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } //case 2 if right is sorted move left
            else {
                r = mid - 1;
            }

        }//while
        return min_val;

    }
}
