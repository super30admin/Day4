// Time complexity is O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes (https://leetcode.com/submissions/detail/569707402/)
// Any problem you faced while coding this:
using System;

namespace FindPeak
{
    class Program
    {
        public static int FindPeakElement(int[] nums) {
        int left = 0;
        int right = nums.Length -1;
        
        while(left < right) {
                int mid = left + (right - left)/2;
                if(nums[mid] < nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }

        static void Main(string[] args)
        {
            int[] nums = new int[]{1,2,1,3,5,6,4};
            Console.WriteLine(  Program.FindPeakElement(nums));
        }
    }
}
