// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No No :)

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l =0, m;
        int h = nums.size()-1;
        int min = INT_MAX;
        while(l<=h){
            m = l + (h-l)/2;
            if(nums[m]<min){
                min = nums[m];
            }
            else if(nums[l]>nums[h] && nums[l]<=nums[m]){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return min;
    }
};
