// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * https://leetcode.com/problems/find-peak-element/submissions/
 * 
 *
 */
class Solution {
    public int findPeakElement(int[] nums) {
     
        if(nums == null || nums.length ==0) return -1;
        
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            
            int mid = low + (high - low)/2;
            
            //range checks to avoid out of bound exceptions
            //if mid is peak then return mid
            if((mid==0 || nums[mid] > nums[mid-1]) && 
               (mid == nums.length-1 || nums[mid] > nums[mid + 1])) return mid;
            
            /*now move towards that side which has max element
             as peak will reside on that side, remember peak graph,
             finds local peak in log n time, global peak will need linear time
             */
            if(nums[mid+1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}