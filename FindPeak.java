// Time Complexity : O(n) n: numbeo of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length<1){
            return -1;
        }
        
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                return i;
            }
            
        }
        
        return nums.length-1;
    }
    
}