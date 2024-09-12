// Time Complexity : O(logN) where N=Number of Elements in array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Implemented using Binary Search approach.

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {

        vector<int> res;
        if(nums.size() == 0)
        {
            res.push_back(-1);
            res.push_back(-1);
            return res;
        }
        int start = BinSerachStart(nums,target);
        int end = BinSerachEnd(nums,target);
        res.push_back(start);
        res.push_back(end);
        return res;
    }

    int BinSerachStart(vector<int> &nums, int target)
    {
        int start = 0,end= nums.size()-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                if(mid == 0 || nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                else
                    end = mid -1;
            }
            else if(nums[mid]<target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
    int BinSerachEnd(vector<int> &nums, int target)
    {
        int start = 0,end= nums.size()-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
            {
                if(mid == nums.size()-1 || nums[mid]<nums[mid+1])
                {
                    return mid;
                }
                else
                    start = mid +1;
            }
            else if(nums[mid]<target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
};
