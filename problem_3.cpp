// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l = 0;
        int h = nums.size() - 1;
        
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[m-1] && nums[m] > nums[m+1]) return m;
            else if (m == 0 || nums[m-1] < nums[m]) {
                //move right, possiblity of finding peak is more
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        
        return -1;
    }
};
