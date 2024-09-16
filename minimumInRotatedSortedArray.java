// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        int start = 0, end = nums.length - 1, mid = 0;
        
        while(start < end){
            
            mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            } else {
               
                end = mid;
                
            }
        }
        
        return nums[start];
    }
}