// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//The intution here is, check for the adjacent element next to mid element and use binary search in side of the array where the element is greater than mid as we always find peak element. If we search towards the lower side, we may or may not find the peak element
class PeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])) return mid;
            if(nums[mid] < nums[mid+1]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}