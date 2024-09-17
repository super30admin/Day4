/**
 * TC: O(log n)
 * SC: O(1)
 */
public class PeakElement {

        public int findPeakElement(int[] nums) {
            if(nums.length == 1) {
                return 0;
            }

            int low = 0;
            int high = nums.length - 1;

            while(low <= high) {

                int mid = low  + (high - low)/2;
                // check if mid is smaller than adjecent element
                if ((mid == 0 || nums[mid] > nums[mid -1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                    return mid;
                } else if (mid != 0 && nums[mid] < nums[mid-1]) { // if mid -1 is greater than mid then go to left side -- peak will always find on greater side
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }
}
