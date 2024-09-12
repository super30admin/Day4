// Time Complexity : O(logN)
// Space Complexity : O(1) as I didn't use any extra space, just the temporary variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/find-peak-element/
// Submission Link: https://leetcode.com/submissions/detail/528738447/

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;
        int mid;
        
        while(low < high){
            mid = low + (high - low)/2;
            
            if(mid == nums.size() - 1)
                return mid;
            
            if(nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        
        return low;
    }
};