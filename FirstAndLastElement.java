// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Binary Search to find the first index and binary search to find the last index with the help of first index

public class FirstAndLastElement {
    private int binarySearch(int[] nums, int low, int high, int target,
                             boolean isFirstIndex) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFirstIndex) {
                if (nums[mid] == target) {
                    if (mid == low || nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] == target) {
                    if (mid == high || nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null) return new int[]{-1, -1};

        int length = nums.length;
        if (length == 0) return new int[]{-1, -1};
        if (nums[0] > target && nums[length - 1] < target) {
            return new int[]{-1, -1};
        }

        // to find first index, BS for entire array
        int firstIndex = binarySearch(nums, 0, length - 1, target, true);
        if (firstIndex == -1) return new int[]{-1, -1};
        // to find second index, BS from first index to last element in the array
        int secondIndex = binarySearch(nums, firstIndex, length - 1, target, false);
        return new int[]{firstIndex, secondIndex};
    }
}
