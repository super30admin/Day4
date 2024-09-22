// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid= low+ (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1])&& (mid==nums.length-1 || nums[mid]>nums[mid+1])){ //base case
                return mid;
            }
            else if(mid==0){ //
                low=mid+1;
            }
            else if(mid==nums.length-1){
                high=mid-1;
            }
            else if(nums[mid-1]>nums[mid+1]){ //prev ifs are to ensure this condition doesn't throw an error
                high=mid-1;
            } else low=mid+1;
        }
        return -1;
    }
}
