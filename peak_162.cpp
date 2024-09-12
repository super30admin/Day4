// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.empty() && nums.size() == 0){
            return -1;
        }
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
           
            if((mid == nums.size() - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid - 1])){
                return mid;
            }
            else if(mid == 0 || nums[mid] > nums[mid - 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
};
