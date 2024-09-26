// Time Complexity : O(logn) 
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: FIND FIRST INDEX USING BS AND THEN FIND LAST INDEX

// 1. Finding first index: Find the target using BS and once found see if it is same as left element; if no its the first index
// 2. If it is same as left then make high=mid-1
// 3. Repeat similar process to find last index 

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result = {-1,-1};
        if(nums.size() == 0)
            return result;
        int low = 0, high = nums.size()-1, first=-1, last=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid-1>=low && nums[mid-1] == target)
                    high = mid-1;
                else{
                    first = mid;
                    break;
                }
            }
            else{
                if(target<nums[mid])
                    high=mid-1;
                else
                    low = mid+1;
            }
        }
        low = 0; high = nums.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target){
                if(mid+1<=high && nums[mid+1] == target)
                    low = mid+1;
                else{
                    last = mid;
                    break;
                }
            }
            else{
                if(target<nums[mid])
                    high=mid-1;
                else
                    low = mid+1;
            }
        }
        
        result[0] = first;
        result[1] = last;
        return result;
    }
};