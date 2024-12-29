/* ***************************
 1. Check if the vector is sorted by comparing the first and the last element and return first element if it's sorted.
 2. Check if the mid is greater than the element on the left and right of the vector and elements are avaiable to make the comparison then return mid
 3. Update low to mid+1 if element on the mid is less than low or else update the high an continue with the binary search
    Time Complexity : O (log(N))
    Space Complexity : O(1)
    Did this code successfully run on Leetcode : Yes
 ****************************/

class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        if (nums.empty())
        {
            return -1;
        }

        int low = 0, high = nums.size() - 1;

        while (low <= high)
        {
            if (nums[low] <= nums[high])
            {
                return nums[low];
            }

            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.size() - 1 || nums[mid + 1] > nums[mid]))
            {
                return nums[mid];
            }

            if (nums[low] <= nums[mid])
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
};