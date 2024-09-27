// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int mid = 0;
        int left = 0;
        int right = nums.size() - 1;
       while (left <= right)
        {
            mid = left + (right - left) / 2;
            if (((mid == 0) || (nums[mid] > nums[mid - 1])) && ((mid == nums.size() - 1) || (nums[mid] > nums[mid + 1]))) 
                return mid;
            else if((mid != 0) && (nums[mid] < nums[mid - 1])) right = mid - 1;
            else  left = mid + 1;
        }
        return 0;
    }
};
