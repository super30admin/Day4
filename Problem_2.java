// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length -1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
                low = mid + 1; 
            }else{
                high = mid;
            }
        }
        return nums[low];
