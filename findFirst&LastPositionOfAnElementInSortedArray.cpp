//time complexity: O(logn)
//space complexity:O(1)
//approach: binary search, check for mid and its left & right
//solved on leetcode? yes
//problem faced? yes, inside the first if statement but understood it.
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>res;
        int l=0;
        int r=nums.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                int x=nums[mid];
                int l=r=mid;
                int size=nums.size();
                while(l>=1 && nums[l-1]==x)
                    l--;
                while(r<=size-2 && nums[r+1]==x)
                    r++;
                res=vector<int>{l,r};
            }
            if(nums[mid]<target)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        if(res.size()==0)
        {
           res=vector<int>{-1,-1};
        }
        return res;
    }
};