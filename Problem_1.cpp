// Author: Subhed Chavan
// Batch: December 24
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {

        vector<int> res{-1, -1};

        // Check if the input array is empty and return not found
        if (nums.empty())
        {
            return res;
        }

        // Also checking if target is smaller or greater than the elemets present at start and begining of the array provided and return not found
        if ((target < nums[0]) || (target > nums[nums.size() - 1]))
        {
            return res;
        }

        // Run Binary Search to locate the first index
        int first = findFirst(nums, target);

        // If first index is not found, that means the element is not present
        if (first == -1)
        {
            return res;
        }

        // If found, look for the last occurance
        int last = findLast(nums, target);

        // Store occurances in response array and return
        res = {first, last};

        return res;
    }

    int findFirst(vector<int> &nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // If target is found at mid and element before it is not the same, return the mid index, else keep moving left
            if (nums[mid] == target)
            {
                if (mid == 0 || nums[mid - 1] != target)
                {
                    return mid;
                }
                high = mid - 1;
            }

            // If mid is smaller than the target, move towards right half
            else if (nums[mid] < target)
            {
                low = mid + 1;
            }

            // Else search in the left half
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }

    int findLast(vector<int> &nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            // If target is found at mid and element after it is not the same, return the mid index, else keep moving right
            if (nums[mid] == target)
            {
                if (mid == nums.size() - 1 || nums[mid + 1] != target)
                {
                    return mid;
                }
                low = mid + 1;
            }

            // If mid is smaller than the target, move towards right half
            else if (nums[mid] < target)
            {
                low = mid + 1;
            }

            // Else move left half
            else
            {
                high = mid - 1;
            }
        }

        return -1;
    }
};