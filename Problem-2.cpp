// Time Complexity : worst case: O(log n), n is size of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no,                                              


// Your code here along with comments explaining your approach

class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        int ans = 0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            // Compare mid with 0th index element and if it greater than that,
            // that means minimum element could be on right, if otherwise then
            // minimum element could be either that or anything to its left.
            if(nums[mid]<nums[0])
            {
                ans= mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return nums[ans];
        
    }
};