// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

// 162. Find Peak Element
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null) return -1;
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int mid;
        
        while(low <= high){
            mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 0;
    }
}