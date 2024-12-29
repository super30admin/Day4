/* ***************************
    1. Perform binary search and find the first occurance of target element from the left.
    2. If the 1st binary search does not return index of the target element return -1.
    3. Perform second binary search and look for the next occurance which appears on the end of the vector
    Time Complexity : O (log(N))
    Space Complexity : O(1)
    Did this code successfully run on Leetcode : Yes

 ****************************/

class Solution
{
public:
    vector<int> searchRange(vector<int> &nums, int target)
    {
        if (nums.empty())
        {
            vector<int> res = {-1, -1};
            return res;
        }

        int first = firstBinarySearch(nums, target);
        if (first == -1)
        {
            vector<int> res = {-1, -1};
            return res;
        }

        int second = secondBinarySearch(nums, target);

        vector<int> res = {first, second};
        return res;
    }

    int firstBinarySearch(vector<int> nums, int target)
    {
        int l = 0, h = nums.size() - 1;

        while (l <= h)
        {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
            {
                if (mid == l || nums[mid - 1] != nums[mid])
                {
                    return mid;
                }
                h = mid - 1;
            }
            else if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }

        return -1;
    }

    int secondBinarySearch(vector<int> nums, int target)
    {
        int l = 0, h = nums.size() - 1;

        while (l <= h)
        {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
            {
                if (mid == h || nums[mid + 1] != nums[mid])
                {
                    return mid;
                }
                l = mid + 1;
            }
            else if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                h = mid - 1;
            }
        }
        return -1;
    }
};