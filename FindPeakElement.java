// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1. If the middle element is less than middle + 1 element, then the peak should lie on the right
//2. So we reduce the search space to the right and go right
//3. Else we go left


class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        
        return left;
    }
}