// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 153
class Solution {
    public int findMin(int[] nums) {
        int low = 0; int high = nums.length -1;
        //check if the index is sorted by index 0 itself
        if(nums[low]<nums[high]){
            return nums[low];
        }
        
        while(low<=high){
            int mid = low + (high-low)/2;
            //check for the minimum along with edge cases as the mid on boundary points
            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid == nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[mid]>nums[high]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
     return -1;   
    }
}