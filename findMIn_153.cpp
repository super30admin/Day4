// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.empty() && nums.size() == 0){
           return -1;
        }
        int low = 0;
        int high = nums.size() - 1;
        if(nums[low] <= nums[high]){
            return nums[low];
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            else if((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.size() - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
};
