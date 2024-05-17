/**
 * Approach: Binary Search
 *           The min element lies in the unsorted part of the array
 *
 * Working:
 *      if the array is SORTED BY ITSELF return the first index i.e low
 *
 *      Find mid and check if midVal is lesser than both right and left side element i.e mid-1 and mid+1
 *          - return mid
 *
 *      check if LEFT PART is sorted, then MOVE SEARCH SPACE TO RIGHT
 *      else RIGHT PART is sorted, MOVE SEARCH SPACE TO LEFT
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 */

class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while(low<=high) {

            if(nums[low] <= nums[high]) {
                return nums[low];

            }

            int mid = low+(high-low)/2;
            int midVal = nums[mid];

            /*
             * mid == low, mid == high
             *
             * ensuring that the mid index does not cross the search space boundary
             * while performing mid-1 and mid+1
             */

            if((mid == low || nums[mid-1] > midVal) && (mid == high || midVal < nums[mid+1]) ) {
                return nums[mid];
            }

            if(nums[low] <= nums[mid]) {
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;

    }
}
