class Solution {
    // Time Complexity : O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach - check if the element at mid is greater than its left and right neighbor, then return mid as it is the peak element.
    //else check if the no to the right of mid is greater than mid, then peak can be found in the right half of the array,
    // adjust low accordingly, else adjust high.
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == len-1 || nums[mid]> nums[mid+1])) {
                return mid;
            } else if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}