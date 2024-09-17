// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    
    int findStart(vector<int>& nums, int target) {
        int l = 0;
        int h = nums.size() - 1;
        
        while (l <= h) {
            int m = l + (h-l) / 2;
            
            if (nums[m] == target) {
                if (m == 0 || nums[m-1] != target) {
                    return m;
                }
                h = m - 1;
            } 
            else if (target < nums[m]) h = m - 1;
            else l = m +1;
        }
        
        return -1;
    }

    int findEnd(vector<int>& nums, int target) {
        int l = 0;
        int h = nums.size() - 1;
        
        while (l <= h) {
            int m = l + (h-l) / 2;
            
            if (nums[m] == target) {
                if (m == nums.size() - 1 || nums[m+1] != target) {
                    return m;
                }
                l = m + 1;
            } 
            else if (target < nums[m]) h = m - 1;
            else l = m +1;
        }
        return -1;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> v(2,-1);
        int s = findStart(nums, target);
        int e = findEnd(nums, target);
        
        if (s != -1 && e != -1) {
            v[0] = s;
            v[1] = e;
        }
        return v;
    }
};
