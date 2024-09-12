// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Trying to implement binary search for this problem took lot of time.


// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        int low = 0;
        int high = nums.length-1;
        return search(nums,low,high);
    }
    public int search(int[] nums, int low, int high){
        
        while(low<high){
        int mid = low+(high-low)/2;
        
        if(nums[mid]>nums[mid+1])
            return search(nums,low,mid);
        else 
            return search(nums,mid+1,high);
        }
        return low;
    }
}