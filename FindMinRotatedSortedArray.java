// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class FindMinRotatedSortedArray {
    
    public int findMin(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return -1;
        if(nums.length == 1)
            return nums[0];

        int low = 0, high = nums.length-1;
        while(low <= high)
        {
            // check if we are in sorted array
            if(nums[low] < nums[high])
                return nums[low];

            int mid = low + (high-low)/2; // avoid integer overflow

            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 ||nums[mid] < nums[mid+1]))
                return nums[mid];
            if(nums[low] <= nums[mid]) // unsorted half has smallest element look there
            {
                low = mid+1;

            }
            else
            {
                high= mid-1;
            }
        }

        return -1;
    }
}