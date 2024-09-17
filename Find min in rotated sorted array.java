// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            
            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            int mid = start + (end - start) / 2;
            
            // checking if mid is pivot
            if ((mid != 0) && (nums[mid] < nums[mid - 1])) {
                return nums[mid];
            }
            else if (nums[mid] <= nums[end]) { // right arr sorted
                end = mid - 1;
            }
            else { // left arr sorted
                start = mid + 1;
            }
        }
        return -1;
    }
}