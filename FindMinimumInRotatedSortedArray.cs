using System;
namespace Algorithms
{
    /// Time Complexity : O(Logn) 
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class FindMinimumInRotatedSortedArray
    {
        public int FindMin(int[] nums)
        {
            if (nums == null && nums.Length == 0) return -1;

            int low = 0, high = nums.Length - 1;
            int mid = 0;
            while (low <= high)
            {
                if (nums[low] <= nums[high]) return nums[low];
                mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] < nums[mid + 1]))
                {
                    return nums[mid];
                }
                //find range
                if (nums[low] <= nums[mid])
                {
                    //left side is sorted
                    low = mid + 1;
                }
                else
                {
                    //right side is sorted
                    high = mid - 1;
                }
            }

            return -1;
        }
    }
}
