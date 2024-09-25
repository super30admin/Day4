// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
regular Binary search, check if the mid number is greater than mid+1 number
 */

class PeakElement {
    public int findPeakElement(int[] nums) {
        int low=0, high=nums.length-1,mid;

        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1]){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return low;
    }
}