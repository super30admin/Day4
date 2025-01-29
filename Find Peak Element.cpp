// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 0) return -1;
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            // check for peak and also the edge cases
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] > nums[mid + 1])) 
                return mid;
            // else move towards the bigger element, since nums[i] != nums[i + 1] & nums[-1] = nums[n] = -∞, we will find a peak
            // take care of mid else runtime error
            else if(mid > 0 && nums[mid] < nums[mid - 1]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
};