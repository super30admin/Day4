// Time Complexity : O(logN)
// Space Complexity : O(logN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) {
            return Integer.MIN_VALUE;
        } 
        int left = 0, right = nums.length-1;
        if(nums[0]<nums[right]){
            return nums[0];
        }
        while (left < right-1) {
            int mid = left + (right-left)/2;
            if (nums[mid] > nums[right]) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return nums[right];
        }
        return nums[left];
    }
}