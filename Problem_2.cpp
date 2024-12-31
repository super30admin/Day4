// Author: Subhed Chavan
// Batch: December 24
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution
{
public:
    int findMin(vector<int> &nums)
    {

        // If only one element is present then it should be the minimum;
        if (nums.size() == 1)
        {
            return nums[0];
        }

        int n = nums.size();
        int low = 0;
        int high = n - 1;

        // Binary Search
        while (low <= high)
        {

            // Check if array is already sorted, if yes then the first element is going to be the minimum
            if (nums[low] <= nums[high])
            {
                return nums[low];
            }

            // Calculate minimum

            int mid = low + (high - low) / 2;

            // If the mid - 1 element is greater than mid element & mid + 1 is also greater we return mid element
            // Also we check if mid is at the begining or end
            if (((mid == 0) || (nums[mid - 1] > nums[mid])) &&
                ((mid == n - 1) || (nums[mid + 1] > nums[mid])))
            {
                return nums[mid];
            }

            // If element at low is smaller than number at mid we set our low at mid + 1 as the left half is sorted
            if (nums[low] <= nums[mid])
            {
                low = mid + 1;
            }

            // Else we move to left half
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
};