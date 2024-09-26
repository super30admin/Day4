using System;
namespace Algorithms
{
    public class FirstAndLastPositionInSortedArray
    {
        public int[] SearchRange(int[] nums, int target)
        {
            int firstOccurance = findBound(nums, target, true);
            if (firstOccurance == -1)
            {
                return new int[] { -1, -1 };
            }
            int lastOccurance = findBound(nums, target, false);
            return new int[] { firstOccurance, lastOccurance };
        }

        private int findBound(int[] nums, int target, bool isFirst)
        {
            int low = 0, high = nums.Length - 1;
            int mid;
            while (low <= high)
            {
                mid = low + (high - low) / 2;
                if (nums[mid] == target)
                {
                    if (isFirst)
                    {
                        if (mid == low || nums[mid - 1] != target)
                        {
                            return mid;
                        }
                        high = mid - 1;
                    }
                    else
                    {
                        if (mid == high || nums[mid + 1] != target)
                        {
                            return mid;
                        }
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
}
