// Time Complexity : O(logn)
// Space Complexity :  O(n) - In Place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
public:
    int findBinaryPeak(vector<int>& nums, int l, int r)
    {
        // Single Element Case
        if(nums.size() == 1)
            return l;
        
        // Double Element Case
        if(r-l == 1)
        {
            if(nums[r] > nums[l])
                return r;
            else
                return l;
        }
        
        int m = l + floor((r-l)/2);
        
        // Mid-point is First element
        if(m == 0)
        {
            if(nums[m] > nums[m+1])
                return m;
            else
                return -1;
        }
        
        //Mid-point is Last Element
        if(m == nums.size()-1)
        {
            if(nums[m] > nums[m-1])
                return m;
            else
                return -1;
        }
        
        //Peak Condition
        if(nums[m] > nums[m-1] && nums[m] > nums[m+1])
        {
            return m;
        }
        //Peak in Right Half condition
        else if(nums[m-1] > nums[m])
        {
            return findBinaryPeak(nums, l, m-1);
        }
        //Peak in Left Hald Condition
        else
        {
            return findBinaryPeak(nums, m+1, r);
        }
        
        //Shouldn't come here
        return -1;
    }
    
    int findPeakElement(vector<int>& nums) {
        
        int idx = findBinaryPeak(nums, 0, nums.size()-1);
     
        return idx;
    }
};