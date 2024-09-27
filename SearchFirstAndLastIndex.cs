using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class SearchFirstAndLastIndex
    {
        public int[] SearchRange(int[] nums, int target)
        {
            if (nums == null || nums.Length == 0)
                return new int[] { -1, -1 };

            if (target<nums[0] || target > nums[nums.Length - 1])
            {
                return new int[] { -1, -1 };
            }

            int first = SearchFirstIndex(nums, target);

            if (first == -1)
            {
                return new int[] { -1, 1 };
            }

            int second = SearchSecondIndex(nums, target);


            return new int[] { first, second };

        }

        public int SearchFirstIndex(int[] nums, int target)
        {
            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;


                if (target == nums[mid])
                {
                    if (mid == 0 || nums[mid - 1] < nums[mid])
                    {
                        return mid;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
                else if (target < nums[mid])
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


        WWW
        public int SearchSecondIndex(int[] nums, int target)
        {
            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;

                if (target == nums[mid])
                {
                    if (mid == nums.Length - 1 || nums[mid + 1] > nums[mid])
                    {
                        return mid;
                    }
                    else
                    {
                        low = mid + 1;
                    }

                }
                //else if (target < nums[mid - 1])
                //{
                //    high = mid - 1;
                //}
                //else
                //{
                //    low = mid + 1;
                //}

                else if (target>nums[mid])
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
}
