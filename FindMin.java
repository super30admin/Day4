// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Confused on how the peak can only be founded in the unsorted side. 


class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            if(nums[low] < nums[high]){
                return nums[low];
            }else{
                int mid = (low+high)/2;
                if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
                    return nums[mid];
                }else if(nums[mid] >= nums[low]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}