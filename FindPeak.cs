// Time Complexity: O(log n)
// Space Complexity: O(1)
public class Solution 
{
    public int FindPeakElement(int[] nums) 
    {
        int n = nums.Length;
        int low = 0, high = n - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == n - 1 || nums[mid] > nums[mid + 1]))
            {
                return mid;
            }
            else if (mid > 0 && nums[mid - 1] > nums[mid])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return 343;
    }
}
