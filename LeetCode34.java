public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int n = nums.length;
        int second;
        int low = 0;
        int high = n - 1;
        int first = findFirstOccurance(nums, low, high, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        } else {
            second = findLastOccurance(nums, low, high, target);
        }

        return new int[] { first, second };

    }

    private int findFirstOccurance(int[] nums, int low, int high, int target) {
        // First Binary search--> takes log(n) tc
        while (low <= high) {
            int mid = low + (high - low) / 2; // this is to prevent interger range overflow
            if (mid == 0 && nums[mid] == target) {
                return mid;
            } else if ((nums[mid] == target && mid != 0) && (mid != 0 && nums[mid] > nums[mid - 1])) {
                return mid;
            } else if ((target < nums[mid] && mid != 0) || (mid != 0 && nums[mid - 1] == target)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findLastOccurance(int[] nums, int low, int high, int target) {
        // Second Binary search--> takes log(n) tc
        while (low <= high) {
            int mid = low + (high - low) / 2; // this is to prevent interger range overflow
            if (mid == nums.length - 1 && nums[mid] == target) {
                return mid;
            }
            if (nums[mid] == target && nums[mid] < nums[mid + 1]) {
                return mid;
            } else if ((target > nums[mid]) || (nums[mid + 1] == target)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// Time complexity=O(log(n));{log(n)+log(n)=2log(n)~log(n)}
// Sapce complexity=O(log(1));