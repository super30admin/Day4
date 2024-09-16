// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes( Array out of bound exceptions but solved)


// Your code here along with comments explaining your approach
Approach using Binary search and taking a Left and right pointer from the Middle element and checking the neighbouring elements
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        while(left < right){
            mid = left + (right-left)/2;
            if(nums[mid] < nums[mid+1]) left = mid+1;
            else right = mid;
        }
        return left;
    }
}
