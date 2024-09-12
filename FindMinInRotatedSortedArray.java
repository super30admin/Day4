class Solution {

    // 4,5,6,7,0,1,2
    // Linear search - brute force solution
    //Binary search - check if the array is rotated. Compare first and last. if not return first element
    // one side is always sorted. ignore sorted side. Binary search on unsorted until
    // mid -1 > mid

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (nums[low] <= nums[high]) {
            return nums[low];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2; // skip integer overflow

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}