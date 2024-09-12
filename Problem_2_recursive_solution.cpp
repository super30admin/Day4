#include <iostream>
#include <vector>
#include <cmath>
#include <climits>

using namespace std;
class Solution
{
public:
    int findMin(vector<int> &nums)
    {
        int min = INT_MAX;
        int l = 0;
        int r = nums.size() - 1;
        return helper_1(nums, l, r, min);
    }

    int helper_1(vector<int> &nums, int l, int r, int min)
    {
        //base case
        if (l <= r)
        {
            int mid = l + floor((r - l) / 2);
            if (nums[mid] <= nums[r])
            { //right sorted
                if (min > nums[mid])
                {
                    return helper_1(nums, l, mid - 1, nums[mid]);
                }
                else
                {
                    return helper_1(nums, l, mid - 1, min);
                }
            }
            else if (nums[mid] >= nums[l])
            { //left sorted
                if (min > nums[l])
                {
                    return helper_1(nums, mid + 1, r, nums[l]);
                }
                else
                {
                    return helper_1(nums, mid + 1, r, min);
                }
            }
        }
        return min;
    }
};