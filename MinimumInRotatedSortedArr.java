class Solution {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    // thought process: We're looking for the unsorted part of the array as that is where the minimum element always lies
    //because the array is rotated, the minimum element will always be in the unsorted part
    public int findMin(int[] nums) {
       if (nums.length ==1){
        return nums[0];
       }
       int low = 0;
       int high = nums.length -1;

       while (low <= high){
        if (nums[low]<= nums[high]){
            return nums[low];
        }
        int mid = low + (high - low)/2;
        if (nums[low] <= nums[mid]){
            low = mid +1;
        }
        else {
            high = mid ;
        }
       }
       return nums[low]; 
    }
}