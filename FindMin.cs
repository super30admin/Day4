public class Solution
{
    public int FindMin(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return Int32.MaxValue;
        }
        if (nums.Length == 1)
        {
            return nums[0];
        }

        var low = 0;
        var high = nums.Length - 1;
        while (low <= high)
        {
            if (nums[low] <= nums[high])
            {
                return nums[low];
            }
            var mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] < nums[mid + 1]))
            {
                return nums[mid];
            }
            if (nums[low] <= nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return Int32.MaxValue;
    }
}