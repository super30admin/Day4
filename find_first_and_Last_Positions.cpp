// 34_First_and_Last_Position_in_sorted_Array.cpp : This file contains the 'main' function. Program execution begins and ends there.
//Time Complexity - O(logN)
//Space Complexity - O(1)

#include <iostream>
#include<vector>

using namespace std;
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> output(2);
        output[0] = leftIndex(nums, 0, nums.size() - 1, target);
        output[1] = rightIndex(nums, 0, nums.size() - 1, target);
        return output;
    }
    //find the left most index by traversing through left array if target>=nums[mid]
    int leftIndex(vector<int>& nums, int start, int end, int target) {
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                index = mid;
            if (nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return index;
    }

    //find the right most index by traversing through right array if target<=nums[mid]
    int rightIndex(vector<int>& nums, int start, int end, int target) {
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                index = mid;
            if (nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return index;
    }


};
int main()
{
    Solution s;
    vector<int> nums{ 5, 7, 7, 8, 8, 10 };
    int target = 8;
    vector<int> output = s.searchRange(nums, target);
    cout << output[0] << ", " << output[1] << endl;
    return 0;
}