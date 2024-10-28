// Time Complexity : O(log n) as we are using binary search
// Space Complexity : O(1) Constant space as the amount of extra space used does not depend on number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Doing 2 binary searches to identify the first and the last index
class FirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int firstIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                firstIndex = mid;
                high = mid - 1; // Continue to search in the left half
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return firstIndex;
    }

    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                lastIndex = mid;
                low = mid + 1; // Continue to search in the right half
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        FirstAndLastPositionInSortedArray finder = new FirstAndLastPositionInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = finder.searchRange(nums, target);
        System.out.println("First and Last Position: [" + result[0] + ", " + result[1] + "]");
    }
}

