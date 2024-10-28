// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) Constant space as the amount of extra space used does not depend on number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindMinSortRotatedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int n = nums.length - 1;

        while (low <= high) { // check if it is a sorted array or not. if yes, return nums of low which will be the minimum
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            // check if mid is the minimum
            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums[n - 1] || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }
            // Check if left half of the array is sorted or not
            if (nums[low] <= nums[mid]) {
                low = mid + 1; // move low to mid+1
            } else {
                high = mid - 1; // right half is sorted so move high to mid -1
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        FindMinSortRotatedArray searcher = new FindMinSortRotatedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int min = searcher.findMin(nums);
        System.out.println("Minimum element: " + min); // Output should be 0
    }
}