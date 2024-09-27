// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() == 0) return -1;
        int left = 0;
        int right = nums.size() - 1;
        int mid = 0;
        while(left <= right)
        {
            mid = left + (right - left) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size()-1 || nums[mid] < nums[mid + 1])) return nums[mid];
            else if (nums[right] < nums[mid]) left = mid + 1;// left is sorted moving to right
            else // right half is sorted
                right = mid - 1; // moving to left 
        }
        return -1;//never reaches here
    }
};
