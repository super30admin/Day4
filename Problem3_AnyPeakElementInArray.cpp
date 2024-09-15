// Time Complexity : O(log n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.empty()) return -1;
        int low=0; int high=nums.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1])
               && (mid==nums.size()-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if(mid >0 && nums[mid]<nums[mid-1]){
                high=mid-1;
            }else
                low=mid+1;
            
        }
        return -1;
        
    }
};