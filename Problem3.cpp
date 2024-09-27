// Time Complexity : T(n) = O(logn)
// Space Complexity :S(n)=O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    int findPeakElement(vector<int>& nums) 
    {
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if ( (mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.size()-1 || nums[mid]>nums[mid+1]) )
            {
                return mid;
            }
            else if(mid!=0 && nums[mid-1]>nums[mid] )
            {
                high=mid-1;
            }
            else if(mid!=nums.size()-1 && nums[mid+1]>nums[mid])
            {
                low=mid+1;
            }
        }
        return 23444556;
    }
};
