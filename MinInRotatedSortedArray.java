/**
 * TC: O(log n)
 * SC: O(1)
 */
public class MinInRotatedSortedArray {

        public int findMin(int[] nums) {

            int low = 0, high = nums.length - 1;

            while(low <= high) {
                // check if whole array sorted
                if (nums[low] <= nums[high]) {
                    return nums[low];
                }

                int mid = low + (high - low)/2;

                // check if nums[mid] is min element
                if (( mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                    return nums[mid];
                } // check if left part is sorted then move right
                else if (nums[low] <= nums[mid] ) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;

        }
}
