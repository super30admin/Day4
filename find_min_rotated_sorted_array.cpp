// Time Complexity : O(logn)
// Space Complexity :  O(n) - In Place
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
public:
    
    int findPivot(vector<int>& nums, int l, int r)
    {
        // Pivot not found condition
        //Implies an unrotated array
        if(l == r)
        {
            return -1;
        }
        
        int m = floor((l+r)/2);
        
        // Found the largest element
        if(nums[m] > nums[m+1])
        {
            return m;
        }
        // Left Half condition
        else if(nums[l] > nums[m])
        {
            return findPivot(nums, l, m);
        }
        // Right Half condition
        else if(nums[m+1] > nums[r])
        {
            return findPivot(nums, m+1, r);
        }
        else
        {
            cout << "Shouldn't come here";
            return -1;
        }
    }
    
    int findMin(vector<int>& nums) {
        
        int idx = findPivot(nums, 0, nums.size()-1);

        //idx+1 because Smallest element needed      
        return nums[idx+1];
        
    }
};