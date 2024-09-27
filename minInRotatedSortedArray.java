// Time Complexity : O(logn) where n is the length of the nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class minInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (nums.length == 1) return nums[0];
        if (nums[high] > nums[low]) return nums[low];
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid+1] < nums[mid]) return nums[mid+1];
            if (nums[mid-1] > nums[mid]) return nums[mid];
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;  
            }
        }
        return -1;
    }
}