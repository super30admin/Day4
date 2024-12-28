public class Solution
{
    public int[] SearchRange(int[] nums, int target)
    {
        if (nums == null || nums.Length == 0)
        {
            return [-1, -1];
        }

        var pivot = Find(nums, target);
        Console.WriteLine($"pivot: {pivot}");
        if (pivot == -1)
        {
            return [-1, -1];
        }
        var result = new int[2];
        int boundry = -1;
        for (var i = pivot; i >= 0; i--)
        {
            if (nums[i] == target) continue;
            else
            {
                boundry = i;
                break;
            }
        }
        result[0] = boundry + 1;
        boundry = nums.Length;
        for (var i = pivot; i < nums.Length; i++)
        {
            if (nums[i] == target) continue;
            else
            {
                boundry = i;
                break;
            }
        }
        result[1] = boundry - 1;
        return result;
    }

    public int Find(int[] nums, int target)
    {
        int low = 0, high = nums.Length - 1;
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            if (nums[mid] == target)
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
}