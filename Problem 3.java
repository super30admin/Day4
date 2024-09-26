// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : I tried to do it in recursive way and wasn't able to. I am not able to find my mistake.


// Your code here along with comments explaining your approach

class Solution {
    int[] nums;
    int target;
    
    private int findPeak(int low, int high){
        if(low>high) return -1;
        
        int mid = low+(high-low)/2;
        
        if((mid==0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid]>nums[mid+1]))
            return mid;
        else if(mid>0 && nums[mid]<nums[mid-1])
            return findPeak(mid+1, high); //peak is on right side
        else
            return findPeak(low, mid-1); // peak is on left
    }
    
    public int findPeakElement(int[] nums) {
        this.nums = nums;
        this.target = target;
        
        if(nums.length == 1)
            return 0;
        
        return findPeak(0, nums.length-1);
    }
}