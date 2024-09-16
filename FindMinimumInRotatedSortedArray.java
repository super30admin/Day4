// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//1. If the middle element is less than middle - 1 element, then we are at the pivot of the rotated array and found our minimum
//2. If the middle element is greater than both left and right, then we are in the search space with larger elements and we should go right
//3. Else we go left

class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else if(nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}