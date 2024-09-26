// Time Complexity :
// findMin = O(log m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int findPeakElement(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums.length == 1 || (low == 0 && nums[low] > nums[low +1]))
                return low;
            if(high == nums.length - 1 && nums[high] > nums[high - 1])
                return high;
            if((mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid + 1])) 
                return mid;
            
            if( mid !=0 && nums[mid] < nums[mid - 1] ) {
                high = mid - 1;
            } else 
                low = mid + 1;
        }
        return -1;
    }
}