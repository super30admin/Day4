/*
    Leetcode problem 153: Find Minimum in Rotated Sorted Array
    T.C: O(log(n)) :: S.C: O(1)

    Solved using B.S technique -
    Base case is to check if the element at low < high (the array is sorted)
    then calculate the mid and check if the mid is the min element
    if not then the min element lies in the unsorted half of the array
    assign low and high accordingly and re-iterate
*/
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low) / 2;

            if ((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } 

            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return Integer.MAX_VALUE; //value = 2^31 - 1
    }
}