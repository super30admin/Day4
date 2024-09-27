// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findStartIndex(vector<int>& nums, int target)
    {
        if(nums.size() == 0) return -1;
        int left = 0;
        int right = nums.size() - 1;
        int mid = 0;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if ((nums[mid] == target) && (mid == 0 || nums[mid - 1] < target)) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    int findLastIndex(vector<int>& nums, int target)
    {
        if(nums.size() == 0) return -1;
        int left = 0;
        int right = nums.size() - 1;
        int mid = 0;
        while (left <= right)
        {
            mid = left + (right - left) / 2;
            if ((nums[mid] == target) && (mid == nums.size() - 1 || nums[mid + 1] > target)) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        
        int startIndex = findStartIndex(nums, target);
        int lastIndex = findLastIndex(nums, target);
        result.push_back(startIndex);
        result.push_back(lastIndex);
        return result;
    }
};
