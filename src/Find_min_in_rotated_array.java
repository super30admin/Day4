// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
 *
 */

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        if(nums.length == 1) return nums[low];
        if(nums[low] < nums[high]) return nums[low];
        
        while(low <= high) {
            int mid = low + (high-low)/2;
            
            if(low == high) return nums[low];
            
            if(mid < high && nums[mid] > nums[mid +1]) return nums[mid+1];
            if(mid > low && nums[mid] < nums[mid-1]) return nums[mid];
            
            if(nums[low] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}


//another approach

class Solution {
    public int findMin(int[] nums) {
        int low =0, high = nums.length - 1;
        
        if(nums == null || nums.length == 0) return -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            //if array is sorted then return low
            if(nums[low] <= nums[high]) return nums[low];
            
            //if mid is min (min will be small compared to both neighbors)
            if((mid == 0 || nums[mid] < nums[mid -1]) && 
               (mid == nums.length-1 || nums[mid] <nums[mid+1]))
                return nums[mid];
            
            //if right array is sorted, move to the left in unsorted array
            if(nums[mid] < nums[high]) {
                high = mid -1;
            }else {
            	//else move to the right
                low = mid + 1;
            }
        }
        return -1;
    }
    
}