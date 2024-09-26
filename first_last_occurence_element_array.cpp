// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class Solution {
public:
    int calcfirstindex(vector<int>& nums, int target)
    {
            int left=0,right=nums.size()-1;
            int left_index=-1;
            while(left<=right)
            {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                left_index=mid;
                right=mid-1;
            }
            else if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
            }
            return left_index;
    }
    int calclastindex(vector<int>& nums,int target)
    {
        int left=0;int right=nums.size()-1;
        int right_index=-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]==target)
            {
                right_index=mid;
                left=mid+1;
            }
            else if(nums[mid]>target)
                right=mid-1;
            //left=mid+1;
            else
                //right=mid-1;
                left=mid+1;
        }
        return right_index;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>v;        
        int first_index=calcfirstindex(nums,target);
        int right_index=calclastindex(nums,target);
        v.push_back(first_index);
        v.push_back(right_index);
        return v;
    }
};