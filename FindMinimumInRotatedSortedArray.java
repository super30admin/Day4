/**
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if mid element is the minimum element
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Check if mid+1 element is the minimum element
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Adjust the search range
            if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = sol.findMin(nums);
        System.out.println("Minimum element in the rotated sorted array: " + result);
    }
}