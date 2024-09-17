//time complexity: O(n)
//space complexity:O(1)
//approach: linear search, checking if the current element is greater than left & right
//solved on leetcode? yes, but only 54/59 test cases passed.
//problem faced? yes, it is a brute force approach. Not all test cases passed.


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int res=0;
        if(nums.size()==0 || nums.size()==1)
            return res;
        if(nums.size()==2)
        {
            if(nums[0]>=nums[1])
                return 0;
            else
                return 1;
        }
        if(nums.size()>=3)
        {
            for(int i=1; i<nums.size()-1; i++)
            {
                if(nums[i-1]<nums[i] && nums[i]>nums[i+1])
                {
                    res=i;
                }
            }
        }

        return res;
    }
};