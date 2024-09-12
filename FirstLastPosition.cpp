// Time Complexity : O(2logN)
// Space Complexity : O(1) as I didn't use any extra space, just the temporary variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Submission Link: https://leetcode.com/submissions/detail/527292311/

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> indices(2, -1);
        int start = 0, end = nums.size() - 1;
        int mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            
            if(nums[mid] == target){
                indices[0] = mid;
                end = mid - 1;
            }
            else if(target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        start = 0, end = nums.size() - 1;
        
        while(start <= end){
            mid = (start + end) / 2;
            
            if(nums[mid] == target){
                indices[1] = mid;
                start = mid + 1;
            }
            else if(target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        
        return indices;
    }
};