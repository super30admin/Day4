// Time Complexity : O(logN)
// Space Complexity : O(1) as I didn't use any extra space, just the temporary variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Submission Link: https://leetcode.com/submissions/detail/527514654/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0, end = nums.size() - 1;
        int mid;
        
        while(start <= end){
            mid = start + (end - start) / 2;
            
            if(nums[start] <= nums[mid]){
                if(nums[mid] <= nums[end])
                    return nums[start];
                else
                    start = mid + 1;
            }
            else
                end = mid;
        }
        
        return -1;
    }
};