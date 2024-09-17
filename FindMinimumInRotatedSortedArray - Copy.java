
//the minimum element will always be at the unsorted side!
//Approach -  move on the right/left side wherever the unsorted array lies and perform binary search on it. 
//space - O(1)
//Time - O(log n)
class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {

        if (nums.length == 0 || nums == null)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high])
                return nums[low];

            // look for the sorted array
            int mid = low + (high - low) / 2;
            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid]))
                return nums[mid];

            else if (nums[low] <= nums[mid]) // sorted
            {
                // move right
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return 54654654; // the minimu elements will always exist in array!

    }
}