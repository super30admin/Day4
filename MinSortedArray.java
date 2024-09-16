// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        int left =0,right = nums.length-1;
        
        // Binary Search to find the starting point if in left/right part of the array
        while(left <= right){
            int mid = left+(right-left)/2;
            if((mid == nums.length-1 || nums[mid] < nums[mid+1]) && (mid == 0 || nums[mid] < nums[mid-1])) return nums[mid];
            else if(nums[mid] > nums[right]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}
