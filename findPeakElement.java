// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int findPeakElement(int[] nums) {
        //edge case if the element is null or the array is empty
        if(nums == null || nums.length == 0){
            return -1;
        }
        //initialize the low and high variable
        int low = 0, high = nums.length - 1;
        //iterate till the low is less or equal to high index
        while(low <= high){
            int mid = low + (high - low) / 2;
            //If mid is found in the the first location or mid element is greater than the next element 
            //or mid found at last location or mid element is greater than the previous element 
            if((mid == high || nums[mid] > nums[mid + 1]) && (mid == low || nums[mid] > nums[mid - 1])){
                // found the peak element 
                return mid;
            }
            //if mid element is greater than the next element 
            //we decrement the hight index
            //else we increment the low index till we find the mid
            if(nums[mid] > nums[mid + 1]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        
        }
        return -1;
    }
}