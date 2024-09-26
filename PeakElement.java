// Time Complexity :O(Logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach


class Solution {
    public int findPeakElement(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        if (nums == null || nums.length == 0)
        {
            return -1;
        }

        if(nums.length ==1)
        {
            return 0;
        }
        int mid = -1;
        while(high>=low)
        {
            mid = low+(high-low)/2;
            if(mid>0 && mid<high)
            {
                //checks if this is the peak
                if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1])
                {
                    return mid;
                }

                if(nums[mid+1]>nums[mid] && nums[mid]>nums[mid-1])
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                if(nums[low]>nums[high])
                {
                    return low;
                }
                else
                {
                    return high;
                }
            }
        }

        return mid;
    }
}