// Time Complexity :O(logn)+m where m is no of times target is repeated and n is total elements
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    // normal binary search
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = { -1, -1 };
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return findFirstAndLastIndex(nums, mid);
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public int[] findFirstAndLastIndex(int[] nums, int index) {
        int ptr = index;
        int[] result = new int[2];// as we know the index of target, we'll traverse left till element changes
        while (ptr > 0 && nums[ptr] == nums[ptr - 1]) {
            ptr--;
        }
        result[0] = ptr;
        ptr = index;
        while (ptr < nums.length - 1 && nums[ptr] == nums[ptr + 1]) {// we'll go right till the element changes
            ptr++;
        }
        result[1] = ptr;
        return result;
    }
}

// ----------------BINARY SEARCH FOR BOTH FIRST AND LAST------------------
// Time Complexity :O(logn+logn)=== O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        int[] result = { -1, -1 };
        if (nums.length == 0 || nums == null)
            return result;
        // apply binary search and if mid element is target and either is at 0 index or
        // mid-1 element is
        // diffrent, we store index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == 0 || nums[mid] != nums[mid - 1])) {
                result[0] = mid;
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        // apply binary search and if mid element is target and either is at n-1 index
        // or mid+1 element is
        // diffrent, we store index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((nums[mid] == target) && (mid == nums.length - 1 || nums[mid] != nums[mid + 1])) {
                result[1] = mid;
                break;
            } else if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}