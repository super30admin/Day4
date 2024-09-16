namespace Algorithms
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public class FindAnyPeakUnsortedArray
    {
        //Time Complexity - O(log n) - As we are reducing the search space by half for finding the peak
        //Space Complexity - O(1) - As we are not using any additional space 
        public int FindPeakElement(int[] nums)
        {
            if (nums == null || nums.Length == 0) return -1;

            var left = 0;
            var right = nums.Length - 1;
            while (left <= right)
            {
                var mid = left + (right - left) / 2;

                // Verify if the element in the mid is greater than its neighbours if so return mid
                if ((mid == nums.Length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1]))
                {
                    return mid;
                }
                else if (nums[mid] < nums[mid + 1]) 
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}