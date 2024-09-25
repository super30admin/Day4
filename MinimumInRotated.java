// Time Complexity : O(log(N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Similar to finding the pivot in rotated sorted array.
 */
class MinimumInRotated {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,mid;
        while(low<high){
            mid=low+(high-low)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        return nums[low];
    }
}