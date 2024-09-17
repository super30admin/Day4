// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, took time to figure out a way
// to end recursion and conditions.

class FindPeak {
    public int findPeakElement(int[] nums) {

        return binarySearch(nums, 0, nums.length - 1);

    }

    /* followed recursive approach where if element is smaller than
    its next element than it means a peak if possible on the right side as next
    element itself could also be peak but otherwise if it is larger than its
    next element that means peak would be on left including itself*/
    public int binarySearch(int[] nums, int low, int high){

        if(low == high) return low;

        int mid = low + (high - low)/2;

        if(nums[mid] > nums[mid+1]) return binarySearch(nums, low, mid);

        return binarySearch(nums, mid+1, high);
    }
}
