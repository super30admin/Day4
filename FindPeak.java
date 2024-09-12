class Solution {
// time log n
    // space  - constant
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) &&
                    (mid == 0 || nums[mid] > nums[mid - 1])) { // check boundry
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
