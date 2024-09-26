// Time Complexity : o(logn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if (nums[mid] > nums[mid +1])
                return mid;
            
            if (nums [mid - 1] < nums [mid])
                return mid;
            
            if(nums[mid] > nums[low])
                low = mid+1;
            else
                high = mid -1;
        }
        return -1;
    }
}