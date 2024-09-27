// Time Complexity : T(n) = O(logn)
// Space Complexity :S(n)=O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            if(nums[low]<=nums[high])
            {
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]<nums[mid-1] )&& (mid==nums.size()-1 || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            if(nums[mid]>=nums[low])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -999999;
    }
};
