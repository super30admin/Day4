// Time Complexity : O(log n) where n is size of array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindPeek {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low<high)
        
        {
            if(nums[mid]>nums[mid+1])
                high = mid;
            else
                low = mid+1;
        }
            
        return low;
    }
}