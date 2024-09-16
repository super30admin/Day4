namespace Algorithms
{

    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    public class MinSortedArray
    {
        //Time Complexity - O(log n) - since we reduced the search space by half
        // Space Complexity  - O(1) - Sine we did not use any additional space for performing the operations
        public int FindMin(int[] nums)
        {
            if (nums == null && nums.Length == 0) return -1;

            var left = 0;
            var right = nums.Length - 1;
            while (left <= right)
            {
                var mid = left + (right - left) / 2;
                if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.Length - 1 || nums[mid + 1] > nums[mid]))
                {
                    return nums[mid];
                }
                else if (nums[mid] < nums[right]) // If the right side of the array is sorted, search min on the left side of the array, so move the right pointer
                {
                    right = mid - 1;
                }
                else // If the left sorted, then move the left pointer to the right side 
                {
                    left = mid + 1;
                }
            }

            return 0;
        }

    }
}
