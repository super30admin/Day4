// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
//This algorithm performs a binary search to find a peak element in the array, 
//where a peak is defined as an element greater than its neighbors. 
//It compares the middle element with its neighbors to decide whether to move left or right in search of a higher slope, 
//ensuring it always moves toward a peak. Once the conditions for the peak are met, 
//it returns the index of the peak element.

public class Solution
{
    public int FindPeakElement(int[] nums)
    {
        int low = 0, high = nums.Length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1]))
            {
                return mid;
            }
            else if (nums[mid] < nums[mid + 1])
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

public class Program
{
    public static void Main(string[] args)
    {
        Solution obj = new Solution();
        // Input: nums = [1,2,1,3,5,6,4]
        //Output: 5
        int[] nums = new int[] { 1, 2, 1, 3, 5, 6, 4 };
        int result = obj.FindPeakElement(nums);
        Console.WriteLine(result);
    }
}