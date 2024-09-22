// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
// The approach leverages binary search to find the minimum element in a rotated sorted array. 
//The algorithm compares the middle element to the last element to determine whether the minimum lies in the left or right half of the array.
// By continuously narrowing the search range, the minimum is found when the search space converges on the smallest element.

public class Solution
{
    public int FindMin(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return -1;
        }
        int low = 0, high = nums.Length - 1;
        while (low < high)
        {
            // if(nums[low] <= nums[high]){ //check sorted range
            //     return nums[low];
            // }
            int mid = low + (high - low) / 2;

            //check base case to find min
            // if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == high || nums[mid] < nums[mid+1])){
            //     return nums[mid];
            // } else 
            if (nums[mid] <= nums[high])
            { //right sorted
                high = mid; // mid instead of mid -1 because we dont want to go with partial excluding mid eg: {0, 1, 2} we want to include 1 while checking for min.
            }
            else
            {
                low = mid + 1;
            }

        }
        return nums[low];
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        Solution obj = new Solution();
        //Input: nums = [3, 4, 5, 1, 2]
        //Output: 1

        int[] nums = new int[] { 3, 4, 5, 1, 2 };
        int result = obj.FindMin(nums);
        Console.WriteLine(result);

    }
}