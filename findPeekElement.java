// Time Complexity : O(logn) 
// Space Complexity : O(n) - size of the input array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;//set low to 0
        int high=nums.length-1; // set high to last index of the array
        while(low<=high){ //run till low is less than or equal to high
            int mid = low +(high-low)/2; //Formula to calculate mid avoiding integer overflow 
            if((mid == 0 || nums[mid]>nums[mid-1]) && 
               (mid == nums.length -1 || nums[mid]>nums[mid+1]))// check if the mid element is greater than its both neighboring elements or mid is 0 or the last element of the array.
               { 
                return mid; // if yes, return mid
            }
            else if(mid > 0 && nums[mid]< nums[mid-1]){ // chech, if mid id less than the element to its left and mid is greater than 0
                high = mid-1; // if yes, than change high to mid-1
            }else{ // if the above conditions are not true, than the peek element would be in the right side of mid, so change low to mid+1
                low = mid +1;
            }
        }
       return -1; // if there is no peek then return -1
    }
}