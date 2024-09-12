// Time Complexity : O(logn) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    // In this approach, we will look for the unsorted part of the array
    // if the left side of the array is usorted than change high to mid
    // if right side of the array is unsorted than change low to mid+1
    // return the low, when low is equal to high
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1; // check if nums is empty, then return -1
        int low =0; // set low to 0
        int high = nums.length -1 ; // set high to the last index of the array 
        while(low < high){
            int mid = low +(high - low)/2; // formula to calculate the mid without integer overflow.
            if(nums[mid] > nums[high]) // check if mid is greater than high
            {   low= mid+1; // if yes, than change low to mid+1
            }else{
                high=mid;// if not, than change high to mid
            }
        }
        return nums[low];// whenever the low is equal to high than return mid.
    }
}