// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        int low = 0, high = nums.length-1;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2; // avoid integer overflow
            // mid == 0 and mid == nums.length-1 question says consider it -ve infinity to we assume it high
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(mid != nums.length-1 && nums[mid+1] > nums[mid]) // since we know the highest element we have higher probability to find it there.
            {
                low = mid+1;
            }
            else
                high = mid -1;
        }
        
        return -1;
    }
}
