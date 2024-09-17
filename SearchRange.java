import java.util.Objects;

/**
 * TC: O(log n)
 * SC: O(1)
 */
public class SearchRange {

        public int[] searchRange(int[] nums, int target) {

            if(Objects.isNull(nums) || nums.length == 0) {
                return new int[] {-1,-1};
            }

            int first = binarySearchForFirstPosition(nums, target);

            if (first == -1) {
                return new int[] {-1,-1};
            }

            int last = binarySeachForLastPosition(nums, target);

            return new int[] {first, last};
        }

        private int binarySearchForFirstPosition(int[] nums, int target) {

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) /2;

                // check if target lies in left part
                if (target <= nums[mid]) {
                    if (target == nums[mid] && (mid == low || nums[mid] > nums[mid -1])) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    low = mid + 1;
                }
            }
            return -1;

        }

        private int binarySeachForLastPosition(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while(low <= high) {
                int mid = low + (high - low) /2;

                // check if target lies in right part
                if (target >= nums[mid]) {
                    if (target == nums[mid] && (mid == high || nums[mid] < nums[mid +1]) ) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }
}
