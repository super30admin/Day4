
/*
 *  Time Complexity: O(log n) since we are performing binary search towards the side of the array with increasing sequence of numbers which has a definite chance of having a peek the problem's time complexity is reduced to O(log n)
 *  Space Complexity: Constant as we do not use any extra memory
 * 
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 * 
 *  Similary to the binary search we need to computer the mid element and check if its a peak, else we move our search towards the side which has an increasing sequence of numbers. The fact that there are no consecutive repeating numbers ensures that we reach a peak when me move towards the increasing direction from mid element. Also considering the fact that the edge elements would be followed by negative infinity also ensure we find a peak when all elements are sorted.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        
        int low=0, high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 ||nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])) return mid;
            else if(mid<nums.length-1 && nums[mid]<nums[mid+1]) low = mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
