// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left=0,right=nums.size()-1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return left;
    }
};