// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

// 153. Find Minimum in Rotated Sorted Array
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int high = n-1;
        int low = 0;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]){
                return nums[low];
            }
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }   
            else if (nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 0;
    }
}