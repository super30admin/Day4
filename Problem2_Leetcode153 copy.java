// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        // base case
        if(nums == null || nums.length == 0) return -1;

        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while(low <= high) {
            // in case array completely sorted even after rotating
            if(nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low) / 2; // to avoid integer overflow

            // if left and right element of mid are greater than mid then we found out minimum
            // take care of boundry conditions
            if((mid == low || nums[mid - 1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }

            // find which side of the array is sorted and discard that side because from our observation we know that minimum element will always lie in unsorted side
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}