// Time Complexity : O(log n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length -1;
        
        while(left < right){
            int mid = left + (right - left)/2;
            
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}