class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        // TC : O(logn)
        // SC : O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;
        // checking if the array is already sorted return element in lo index.
        if (nums[lo] <= nums[hi])
            return nums[lo];

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // internal checking if the array is already sorted.
            if (nums[lo] <= nums[hi])
                return nums[lo];

            // if the element left to mid and right to mid are greater than the mid element,
            // it means that the mid element is the minimum in rotated sorted array.
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            // if the array on the left side is already sorted, it means that the minimum
            // element has to be on the right side.
            else if (nums[lo] <= nums[mid])
                lo = mid + 1;
            // if the array on left is not sorted, make the high poin to mid - 1 and search
            // in left side part of the array.
            else
                hi = mid - 1;
        }
        return -1;
    }
}