// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int first_occurance(vector<int>& nums, int target){
        int l =0;
        int h = nums.size()-1;
        int m;
        while(l<=h){
            m = l+(h-l)/2;
            if(nums[m]==target){
                if(m==l || nums[m]>nums[m-1]){
                    return m;
                }
                else{
                    h = m-1;
                }
            }
            else if(nums[m]<target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return -1;
    }
    int last_occurance(vector<int>& nums, int target){
        int l =0;
        int h = nums.size()-1;
        int m;
        while(l<=h){
            m = l+(h-l)/2;
            if(nums[m]==target){
                if(m==h || nums[m]<nums[m+1]){
                    return m;
                }
                else{
                    l = m+1;
                }
            }
            else if(nums[m]<target){
                l = m+1;
            }
            else{
                h = m-1;
            }
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first =0, last=0;
        if(nums.size()==0){
            first = -1;
            last = -1;
        }
        else{
            first = first_occurance(nums, target);
            last = last_occurance(nums, target);
        }
        return {first,last};
    }
};
