// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I was creating a templete similar to binary search and was assuming all the elements were sorted or rotated.


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1;
        if (nums==null || nums.length==0) return -1;

        while (low<=high) {
            int mid = low + (high-low)/2;

            if ((mid==0 || nums[mid] > nums[mid-1]) && (mid==nums.length-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if(nums[mid] <= nums[mid+1]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
}