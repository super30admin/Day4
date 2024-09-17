/* 162. Find Peak Element
*  Time Complexity: O(Log N)
*  Space Complexity: O(1)
* */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;

            if ((middle == 0 || nums[middle - 1] < nums[middle]) &&
                    (middle == nums.length - 1 || nums[middle] > nums[middle + 1])) {
                return middle;
            } else {
                if (middle == nums.length - 1 || nums[middle + 1] > nums[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
