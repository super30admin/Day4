// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
public class FindPeakElementLC162 {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (high == 0)
            return 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // A peak element is an element that is strictly greater than its neighbors.
            // can have more than one element in an array.
            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == high || nums[mid] > nums[mid + 1]))// checking mid -1 >mid> mid+1.
                return mid;
            if (nums[mid] < nums[mid + 1])// if nums[mid] is less,set low from mid+1
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
// YT link:https://youtu.be/TQuyNmM5-pg