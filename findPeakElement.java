// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 162

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0; int high = nums.length-1; 
        while(low<=high){
            int mid = low + (high-low)/2 ; 
            //Check if the mid itself is the peak element otherwise go for the side where the element is higher
            if((mid == 0 || nums[mid]>nums[mid-1]) && ( mid == nums.length-1 || nums[mid]> nums[mid+1]))
            
            {
                return mid;
            }
            else if(nums[mid]< nums[mid+1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
    return -1;
    }
}