// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
1. See if the right of the element is bigger
2. If it's bigger then it means that the number is on the rising solpe and hence the solution exists on the right side
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] < nums[mid+1]) {
               left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}