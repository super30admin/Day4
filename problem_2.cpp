// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        
        if (nums.size() == 0) return -1;
        
        int l = 0;
        int h = nums.size() - 1;
        if (nums[l] < nums[h]) return nums[l];
        
        while(l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[m+1]) return nums[m+1];
            //left sorted case, move right
            if(nums[l] <= nums[m]) {
                l = m + 1;
            } else {
                //right sorted, move left
                h = m - 1;
            }
        }  
        return -1;
    }
};
