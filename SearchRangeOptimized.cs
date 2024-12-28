public class Solution
{
    public int[] SearchRange(int[] nums, int target)
    {
        if (nums == null || nums.Length == 0)
        {
            return new int[2] { -1, -1 };
        }
        if (nums.Length == 1 && nums[0] == target)
        {
            return new int[2] { 0, 0 };
        }
        var first = BinarySearchFirst(nums, target);
        if (first == -1)
        {
            return new int[2] { -1, -1 };
        }
        var second = BinarySearchSecond(nums, target, first);
        return new int[2] { first, second };
    }

    public int BinarySearchFirst(int[] nums, int target)
    {
        var low = 0;
        var high = nums.Length - 1;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            if ((nums[mid] == target) && (mid == 0 || nums[mid - 1] != target))
            {
                return mid;
            }

            if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int BinarySearchSecond(int[] nums, int target, int low)
    {
        int high = nums.Length - 1;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            if (nums[mid] == target && (mid == nums.Length - 1 || nums[mid + 1] != target))
            {
                return mid;
            }
            if (nums[mid] <= target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}