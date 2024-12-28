public class Solution
{
    public int FindPeakElement(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return -1;
        }
        if (nums.Length == 1)
        {
            return 0;
        }

        var low = 0;
        var high = nums.Length - 1;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.Length - 1 || nums[mid] > nums[mid + 1]))
            {
                return mid;
            }

            if (mid > 0 && nums[mid] < nums[mid - 1])
            {
                high = mid - 1;
            }
            else if (mid < nums.Length)
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}