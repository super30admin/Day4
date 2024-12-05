/*
    Leetcode Problem 34: Find First and Last Position of Element in Sorted Array 
    T.C: O(log(n)) - log(n) + log(n) = 2log(n)
    S.C: O(1) - Expected to give out an array of length 2

    Use Binary Search technique to find the position of the target
    1st Binary Search to find leftmost occurence (as the given array is sorted in ascending order)
    2nd Binary Search to find the rightmost occrence.
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[] {-1, -1};
        int firstPos, lastPos;

        if (nums == null || nums.length == 0) return result;
        
        if (target < nums[0] || target > nums[n - 1]) return result;

        firstPos = binarySearch(nums, 0, n - 1, target, "first");

        if (firstPos == -1) {
            return result;
        }

        lastPos = binarySearch(nums, firstPos, n - 1, target, "last");
        
        result[0] = firstPos;
        result[1] = lastPos;

        return result;
    }

    public int binarySearch(int[] nums, int low, int high, int target, String position) {
        while (low <= high) {
            int mid = low + (high - low) / 2; //prevent integer overflow

            if (nums[mid] == target && position.equals("first")) {
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                high = mid - 1;

            } else if (nums[mid] == target && position.equals("last")) {
                if (mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                low = mid + 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}