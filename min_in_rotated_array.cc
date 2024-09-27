// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
public:
    int rotatedBinarySearch(vector<int>& nums, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            //Min is the only unique case where the preceeding value and the succeeding value are greater than it.
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.size() - 1 || nums[mid] < nums[mid + 1]))
                return nums[mid];
            
            if(nums[low] <= nums[mid] && nums[mid] >= nums[high]){ // left sorted so search right
                low = mid + 1;
            }
            else{ //Right sorted
                high = mid - 1;
            }
        }
        return -1;
    }
    
    int findMin(vector<int>& nums) {
        if(nums.empty()) return -1;
        if(nums.size() == 1) return nums[0];
        int low = 0;
        int high = nums.size() - 1;
        if(nums[low] < nums[high]){
            return nums[low];
        }
        return rotatedBinarySearch(nums, low, high);
        
    }
};
