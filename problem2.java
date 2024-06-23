/* first we check if the input array is sorted, if yes then 1st element is the minimum.
 * if not sorted then we know that the minimum/pivot element is on the unsorted side.
 * We use binary search by calculating mid and checking if mid is the pivot (if arr[mid -1] > arr[mid])
 */
class Solution {
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int lo = 0;
        int high = nums.length - 1;

        while (lo <= high) {
            if (nums[lo] < nums[high]) {
                return nums[lo];
            }
            int mid = lo + (high - lo) / 2;
            if ((mid >0 && nums[mid - 1] > nums[mid]) ) {
                return nums[mid];
            } else if (nums[lo] <= nums[mid]) {
                lo = mid + 1;

            } else {
                high = mid;
            }
        }
        return nums[lo];
    }
}