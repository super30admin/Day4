// Time Complexity : worst case: O(log n + log n) for two BS's, n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no,                                              


// Your code here along with comments explaining your approach
class Solution {
    int firstOccurance(vector<int>& nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        int ans = -1;
        while(low <= high)
        {
            int mid = low+(high - low)/2;
            if (nums[mid] == target)
            {
                ans = mid;
                high = mid - 1;
            }
            else if (nums[mid] > target)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return ans;
    }

    int lastOccurance(vector<int>& nums, int target)
    {
        int low = 0;
        int high = nums.size() - 1;
        int ans = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
            {
                ans = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }

public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result;
        int first_occ = firstOccurance(nums, target);
        int last_occ = lastOccurance(nums, target);
        result.push_back(first_occ);
        result.push_back(last_occ);
        return result;
    }
};