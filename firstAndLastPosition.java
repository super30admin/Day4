// Time Complexity: O(log n)
// Space Complexity: O(1)

public class firstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearchFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = binarySearchlast(nums, target);
        return new int[]{first, last};
    }

    private int binarySearchlast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low / 2);
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }
}
