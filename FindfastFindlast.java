/**
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstElement = firstSearch(nums, target);
        int secondElement = secondSearch(nums, target);
        return new int[]{firstElement, secondElement};
    }

    public int firstSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }

    public int secondSearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return last;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = sol.searchRange(nums, target);
        System.out.println("First and last positions of target: [" + result[0] + ", " + result[1] + "]");
    }
}
