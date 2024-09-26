using System;
namespace Algorithms
{
    public class FindArrayPeek
    {
        /// Time Complexity : O(log(n))
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  Refered Online

        public int FindPeakElement(int[] nums)
        {
            int low = 0, high = nums.Length - 1;
            int mid;
            while (low <= high)
            {
                mid = low + (high - low) / 2;
                if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] > nums[mid + 1]))
                {
                    return mid;
                }
                if (nums[mid] < nums[mid + 1])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return 82826;

        }
    }
}

