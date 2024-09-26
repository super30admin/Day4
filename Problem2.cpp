// Time Complexity : O(log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<vector>
#include<iostream>

using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;
        while (low < high && nums[low] > nums[high]) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
};