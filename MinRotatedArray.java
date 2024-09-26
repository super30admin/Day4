// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Here first we will check for the base condition of if the array is of the size 1 or the low is less than the high. Then we will operate the modified binary search. If the mid value if greater than the mid+1, then the pivot value if mid+1 and we return it. If the mid value is less than the mid-1 value, then the ivot value is mid itself and we return the mid. If the mid value is greater then the low then we need to search in the right subarray and we make low = mid + 1 else we need to search in the left subarray and do right = mid - 1;

class Solution {
    public int findMin(int[] nums) {
        
        //base case:
        if(nums.length == 1){
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        
        // if the array is not pivoted
        if(nums[low] < nums[high]){
            return nums[low];
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>nums[low]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;   
    }
}