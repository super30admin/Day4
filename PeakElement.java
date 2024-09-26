// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Here we will first check if the length of array is 1 or 2 and throguh this we will complete edge cases. Then we will apply binary search. If the mid value is greather than the mid+1 value, so it is in the negative slope of the array and we reduce our search space to left subarray and if the mid value is lesser than mid + 1, so we reduce our search space to right subarry and then atlast we return the low value having the index value fo the peak element when both low and high poin towards the it.


class Solution {
    public int findPeakElement(int[] nums) {
        // if length = 1, then output = 0;
        if(nums.length == 1){
            return 0;
        }
        //if length = 2, then ouptut is minimum out of 2
        if(nums.length == 2){
            if(nums[0]<nums[1])
                return 1;
            else
                return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid+1]){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return high;
        
    }
}