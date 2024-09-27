// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Suppose if we have a sorted array in ascending order, the nums[low]<nums[high] is a true condition and
nums[low] will have the minimum element. When an array is rotated, the right part of the element will have
the minimum value. So, we will move the low pointer to right side of the array when nums[low]<=nums[mid].
 */

class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            if(nums[low]<nums[high]) return nums[low];
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1])&&(mid==nums.length-1||nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}