public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        // this is a classic exmple of binary seach on unsorted array but here also we
        // are neglecting one half of the array which is second property of BS.
        // any array will always have peak so no senses of returning -1
        // always move towards the greated side of mid beacuse in smaller side u may or
        // may not find the peak
        // remember the graph which sir drew
        // adjacent will never be same this is important constraint
        // the outside the array both side we consider -infinity or Integer.MIN_VALUE;

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1)
            return 0;

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // preventing integer range overflow
            if ((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == n - 1 && nums[mid] > nums[mid - 1])) {
                return mid;
            } else if ((mid != 0 && nums[mid] > nums[mid - 1]) && (mid != n - 1 && nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid != 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

// time complexity=O(log(n))--> single binary search
// space complexity=O(1)
