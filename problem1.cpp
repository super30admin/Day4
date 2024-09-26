/*
Time complexity - O(logN)
Space complexity - O(1)
*/
class Solution {
private:
    int leftBinSearch(vector<int>& nums, int target){
        int l = 0, r = nums.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (((mid > 0) && (nums[mid] == target && nums[mid - 1] == target)) 
                     || nums[mid] > target) r = mid - 1; 
            else return mid;
        }
        return -1;
    }
    int rightBinSearch(vector<int>& nums, int target){
        int l = 0, r = nums.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) r = mid - 1;
            else if (((mid < nums.size() - 1) && (nums[mid] == target && nums[mid + 1] == target)) 
                     || nums[mid] < target) l = mid + 1; 
            else return mid;
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.size() == 0) return {-1,-1};
        //find lower idx
        int leftIdx = leftBinSearch(nums, target);
        if (leftIdx == -1) return {-1, -1};
        int rightIdx = rightBinSearch(nums, target);
        return {leftIdx, rightIdx};
    }
};