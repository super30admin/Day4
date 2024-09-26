/*
 *  Time Complexity: O(log n) since we are performing binary search
 *  Space Complexity: Constant as we do not use any extra memory
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Similar to Binary search find the mid element and identify the part of array which is sorted and check if the least element in the sorted side smaller than the boundries of the other side of the array. If its smaller we can return that element else we can do a binary search in the other side.
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums[0]<=nums[nums.length-1]) return nums[0];
        int low=0, high=nums.length-1;
        
        while(low<=high){
            int mid=low + (high-low)/2;
            if(nums[mid]>=nums[low]){
                if(mid>=high || (nums[mid+1]>nums[low] && nums[high]>nums[low])) return nums[low];
                else low=mid+1;
            }else{
                if(mid<=low || (nums[mid-1]>nums[mid] && nums[low]>nums[mid])) return nums[mid];
                else high=mid-1;
            }
        }
        return -1;
    }
}
