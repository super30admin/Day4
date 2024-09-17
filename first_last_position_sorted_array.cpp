// Time Complexity : O(2 * logn) - Once for lower idx, once for higher idx
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
public:
    int binarySearchLow(vector<int>& nums, int l, int r, int target)
    {
        // Couldn't find element
        if(r < l)
            return -1;
        
        int m = l + floor((r-l)/2);

        // 0 index Element condition
        if(m == 0)
        {
            if(nums[m] == target)
                return m;
            else
                return -1;
        }
        
        //First Occurrence of Element matched
        if((nums[m] == target) && (nums[m-1] < nums[m]))
        {
            return m;
        }
        //Left Half condition
        else if(target <= nums[m])
        {
            return binarySearchLow(nums, l, m-1, target);
        }
        //Right Half condition
        else
        {
            return binarySearchLow(nums, m+1, r, target);
        }
        
        return -1;
    }
    
    int binarySearchHigh(vector<int>& nums, int l, int r, int target)
    {
        // Couldn't find element
        if(r < l)
            return -1;
        
        int m = l + floor((r-l)/2);
        
        //Last Element condition
        if(m == nums.size()-1)
        {            
            if(nums[m] == target)
                return m;
            else
                return -1;
        }
        
        // Last occurrence of element Matched
        if((nums[m] == target) && (nums[m+1] > nums[m]))
        {
            return m;
        }
        // Right half condition
        else if(target >= nums[m])
        {
            return binarySearchHigh(nums, m+1, r, target);
        }
        // Left half condition
        else
        {
            return binarySearchHigh(nums, l, m-1, target);
        }
        
        return -1;
    }    
    
    vector<int> searchRange(vector<int>& nums, int target) {
        
        vector<int> indices;
        int lIdx = binarySearchLow(nums, 0, nums.size()-1, target);
                
        indices.push_back(lIdx);
        
        int rIdx = binarySearchHigh(nums, 0, nums.size()-1, target);
                
        indices.push_back(rIdx);
                
        return indices;
    }
};