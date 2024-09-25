// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

// Your code here along with comments explaining your approach in three sentences only
// logic here is to simply go towards the higher number so that you would eventually find one of the peaks
// there is a theorom that proves this as well
class Solution {
    public int findPeakElement(int[] nums) {
        
        int low = 0, high = nums.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if((mid==0 || nums[mid]> nums[mid-1]) && (mid == nums.length-1 || nums[mid]> nums[mid+1])){
                return mid;
            }
            else if(nums[mid+1]>nums[mid]){//move right
                low = mid+1;
            }
            else{ //move left
                high = mid-1;
            }
        }
        return -1;
        
    }
}
