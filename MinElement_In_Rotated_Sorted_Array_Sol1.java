// Time Complexity : O(logn) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1; // check if nums is empty, then return -1
        int low =0; // set low to 0
        int high = nums.length -1 ; // set high to the last index of the array 
        while(low <= high){
            if(nums[low]<nums[high])return nums[low]; // At any point, return low if it is less than high
            int mid = low +(high - low)/2; // formula to calculate the mid without integer overflow.
            if((mid == 0|| nums[mid]<nums[mid-1]) && 
               (mid == nums.length-1 || nums[mid]<nums[mid+1]) ) // check if the mid is lesser than its both neighboring elements or mid is 0 or the last element of the array.
            {
                return nums[mid]; // if yes, return mid
            }else if(nums[low]<= nums[mid]) // if no, than check if low is less than or equal to mid
            {
                low=mid+1; // if yes, chnage low to mid+1
            }else{
                high = mid - 1; // If all above staements are not true than the minimum element would be in the left part of the array, so change the high to mid-1
            }
        }
        return -1; // if the element is not present in the array than return -1.
    }
}