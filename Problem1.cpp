// Time Complexity : O(log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
#include<vector>
#include<iostream>

using namespace std;

class Solution {
private:
    int BinaryLow(vector<int> &nums, int target, int low, int high)
    {
        int mid;
        while (low <= high) {
            mid = low + (high-low)/2;
			//Advance low only if it is not pointing to target
            if( nums[mid] == target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    int BinaryHigh(vector<int> &nums, int target, int low, int high)
    {
        int mid;
        while (low <= high) {
            mid = low + (high-low)/2;
			//Advance high only if it is not pointing to target
            if( nums[mid] == target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high;
    }
	
public:

    vector<int> searchRange(vector<int> &nums, int target)
    {
        int size = nums.size(), low = 0, high = size - 1, mid;
        vector<int> pos(2, -1);

        while (low <= high) {
            mid = low + (high - low) / 2;
			
            if (nums[mid] == target) {
                if (nums[low] != target) {
                    low = BinaryLow(nums, target, low, mid);
                }
                if (nums[high] != target) {
                    high = BinaryHigh(nums, target, mid, high);
                }
                pos[0] = low;
                pos[1] = high;
                break;
            }
            else if (nums[mid] > target && nums[high] != target) {
                high = mid - 1;
            }
            else if (nums[mid] < target && nums[low] != target) {
                low = mid + 1;
            }
        }
        return pos;
    }
};