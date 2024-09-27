// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int findMin(int[] nums) {
        //edge case if the element is null or the array is empty
        if(nums == null || nums.length == 0){
            return -1;
        }
        //initialize the low and high variable
        int low = 0, high = nums.length - 1;
         //iterate till the low is less or equal to high index
        while(low <= high){
            int mid = low + (high - low)/ 2;
            //If element at low is less than the element at high we found the minimum element at low
            if(nums[low] < nums[high]){
                return nums[low];
            }
            //if the element is at the start[only one element] or the mid is smaller than the previous element
            // or if element is at the last or the mid is smaller than the next element
            //mid is the minimum element
            if((mid == low || nums[mid] < nums[mid - 1]) &&
               (mid == high || nums[mid] < nums[mid + 1])){
                    return nums[mid];
            }
            //if element at low is smaller than the element at mid  we increment the low
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            //if element at high is greater than the element at mid  we decrement the high
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}