// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int l =0;
        int r = nums.size()-1;
        int m;
        while(l<r){
            m = (l+(r-l)/2);
            if(nums[m]>nums[m+1]){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        return l;
    }
};
