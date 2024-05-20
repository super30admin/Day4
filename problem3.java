/*
    LC - 162. Find Peak Element
    TC - O(log n)
    SC - O(1)
    Approach - Using binary search algorithm to solve this problem. Considering the given constraints, finding the mid element and checking the neighbor element and move the pointer towards the element having greater
    value than the mid value.
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int low =0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow.
            if((mid == low || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])) {
                return mid;
            } else if(nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}