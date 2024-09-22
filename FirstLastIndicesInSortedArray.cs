// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
//The approach uses two binary search functions to find the first and last indexex of the target in a sorted array. 
//The getFirstIndex method narrows down the range to find the first occurrence by checking if the element at mid is the first target or if it should search further left. 
//Similarly, the getLastIndex method finds the last occurrence by moving right or left, ensuring the target at mid is the last occurrence.

public class Solution
{
    public int[] SearchRange(int[] nums, int target)
    {
        int low = 0, high = nums.Length - 1;

        int first = getFirstIndex(nums, low, high, target);
        if (first == -1)
        {
            return new int[] { -1, -1 };
        }
        int last = getlastIndex(nums, first, high, target);
        return new int[] { first, last };
    }

    private int getFirstIndex(int[] nums, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
            {
                low = mid + 1;
            }
            else if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid] > nums[mid - 1])
                {
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int getlastIndex(int[] nums, int low, int high, int target)
    {
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                if (mid == high || nums[mid] < nums[mid + 1])
                {
                    return mid;
                }
                else
                {
                    low = mid + 1;
                }
            }
            else if (nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return -1;
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        //Input: nums = [5,7,7,8,8,10], target = 8
        //Output: [3,4]

        Solution obj = new Solution();
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 6;
        var result = obj.SearchRange(nums, target);
        Console.WriteLine($"[{string.Join(",", result)}]");
    }
}