// Time complexity: O(logN)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

/**
 * The key is to keep reducing the size of array by half
 * 1. Look for target index in left array
 * 2. Look for target index in right array
 */
public class FindFirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                index = mid;
                // if looking for left subarray, high becomes mid - 1
                if (isLeft)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {-1,0,2,2,3,3,3,5,6,6,6,7,7,8,8,8,8,8,9};
        FindFirstAndLastPositionInSortedArray obj = new FindFirstAndLastPositionInSortedArray();
        int[] result = obj.searchRange(array, 8);
        System.out.println("Range is: " + result[0] + " to " + result[1]);
        assert (result[0] == 13);
        assert (result[1] == 17);

        result = obj.searchRange(array, 10);
        System.out.println("Range is: " + result[0] + " to " + result[1]);
        assert (result[0] == -1);
        assert (result[1] == -1);
    }
}
