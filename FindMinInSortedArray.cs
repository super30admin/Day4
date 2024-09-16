// Time complexity is O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode: Yes (https://leetcode.com/submissions/detail/569686526/)
// Any problem you faced while coding this:
using System;

namespace FindMinInSortedArray
{
    class Program
    { 
        public static int FindMin(int[] nums) {
            
            int left = 0;
            int right = nums.Length - 1;
            
            while(left < right) {
                int mid = left + (right - left)/2;
                
                if(nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
            
        }
        static void Main(string[] args)
        {
            int[] nums = new int[]{3,4,5,1,2};
            Console.WriteLine(  Program.FindMin(nums));
        }
    }
}
