// Time Complexity : O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty() || nums.size() == 0){
            vector<int> x = {-1,-1};
            return x;
        }
        if(target < nums[0] && target > nums[nums.size() - 1]){
            vector<int> x = {-1,-1};
            return x;
        }
        int left = binarySearchLeft(nums, target);
        if(left == -1){
            vector<int> x = {-1,-1};
            return x;
        }
        int right = binarySearchRight(nums, target);
        if(right == -1){
            vector<int> x = {-1,-1};
            return x;
        }
        vector<int> y = {left, right};
        return y;
    }
    int binarySearchLeft(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    int binarySearchRight(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == nums.size() - 1 || nums[mid+1] != target){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    
};
