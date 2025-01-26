// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * 
 * Using binary search check if mid is peak then return mid, else if left element is less then right element then prune left part of array,
 * else prune right part of array. Go towards the higher neighbor.
 *
 */
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n-1 || nums[mid]>nums[mid+1]) ){
                return mid;
            }else if(mid<n-1 && nums[mid+1]>nums[mid]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}