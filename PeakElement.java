// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :instead of checking mid and mid+1 I was checking mid and mid-1, then figured out we cannot 
//check mid to mid-1  as in case our mid falls at index 0 it gives index exception and our mid will be at last
//only if it is the single element
class Solution {
    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int n = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // checking for peak
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // if mid element is smaller than mid+1, move start to mid+1
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}